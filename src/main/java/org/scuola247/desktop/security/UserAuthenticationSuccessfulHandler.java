package org.scuola247.desktop.security;

//import javax.persistence.EntityManager;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserAuthenticationSuccessfulHandler implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

//	@PersistenceContext
//	private EntityManager entityManager;

	@Override
	@Transactional
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		Object principal = event.getAuthentication().getPrincipal();
		/*if (principal instanceof JpaUserDetails) {
			User user = entityManager.find(User.class, ((JpaUserDetails) principal).getUserDbId());
			user.setLockedOut(null);
			user.setFailedLogins(null);
			user.setLastLogin(DateTime.now());
		}
		else */if (principal instanceof UtenteDettagli){
			// servirebbe per settare che l'utente non è bloccato e che ha appena fatto un login
		}
	}
}