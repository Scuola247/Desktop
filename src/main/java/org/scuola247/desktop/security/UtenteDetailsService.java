package org.scuola247.desktop.security;

import java.util.HashSet;
import java.util.Set;

import org.scuola247.desktop.service.UserSettings;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//Forse non serve più
@Component
public class UtenteDetailsService implements UserDetailsService {

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//TODO: recuperare utenti dal database
		
		UserSettings settings = new UserSettings();
		
		Set<String> roles = new HashSet<>();
		roles.add("gestori");
		Utente utente = new Utente("admin@scuola247.org", "admin", true, true, Lingue.IT, settings, roles);
		
		if (utente != null){
			return new UtenteDettagli(utente);
		}
		
		throw new UsernameNotFoundException(username);
	}

}
