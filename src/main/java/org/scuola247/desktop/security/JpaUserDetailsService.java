package org.scuola247.desktop.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.scuola247.desktop.entity.QUser;
import org.scuola247.desktop.entity.User;

import com.mysema.query.jpa.impl.JPAQuery;

@Component
public class JpaUserDetailsService implements UserDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = new JPAQuery(entityManager).from(QUser.user).where(QUser.user.email.eq(email))
				.singleResult(QUser.user);
		if (user != null) {
			return new JpaUserDetails(user);
		}

		throw new UsernameNotFoundException(email);
	}

}
