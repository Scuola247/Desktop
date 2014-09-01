package org.scuola247.desktop.security;

//import javax.persistence.EntityManager;
import org.joda.time.DateTime;
import org.scuola247.desktop.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserAuthenticationErrorHandler implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

//	@ - PersistenceContext
//	private EntityManager entityManager;

	@Override
	@Transactional
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		Object principal = event.getAuthentication().getPrincipal();
		
		//TODO annotare login falliti
		if (principal instanceof String) {
			User user = null;/*new JPAQuery(entityManager).from(QUser.user).where(QUser.user.email.eq((String) principal))
					.singleResult(QUser.user);*/
			if (user != null) {
				if (user.getFailedLogins() == null) {
					user.setFailedLogins(1);
				} else {
					user.setFailedLogins(user.getFailedLogins() + 1);
				}

				if (user.getFailedLogins() > 10) {
					/*
					Calendar now = new GregorianCalendar();
					now.add(Calendar.MINUTE, 10);
					*/
					user.setLockedOut(DateTime.now().plusMinutes(10));
				}

			} else {
				LoggerFactory.getLogger(UserAuthenticationErrorHandler.class).warn("Unknown user login attempt: {}",
						principal);
			}
		}
	}
}