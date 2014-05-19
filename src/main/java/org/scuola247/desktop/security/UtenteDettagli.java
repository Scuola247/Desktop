package org.scuola247.desktop.security;

import java.util.Collection;
import java.util.Locale;
import java.util.Set;

import org.scuola247.desktop.service.UserSettings;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

public class UtenteDettagli implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private /*final*/ ImmutableSet<GrantedAuthority> authorities;
	
	private final String username;
	
	private final String password;
	
	private final boolean enabled;
	
	private final boolean locked;
	
	private final Lingue lingua;
	
	private UserSettings settings;

	public UserSettings getSettings() {
		return settings;
	}

	public void setSettings(UserSettings settings) {
		this.settings = settings;
	}

	public UtenteDettagli(Utente utente){
		this.username = utente.getUsername();
		this.password = utente.getPassword();
		this.enabled = utente.isEnabled();
		this.locked = utente.isLocked();
		this.lingua = utente.getLingua();
		this.settings = utente.getSettings();
		ImmutableSet<GrantedAuthority> authorities = getAuthorities(utente.getRoles());
		this.authorities = authorities;
	}
	
	public void setRuoli(Set<String> roles){
		this.authorities = getAuthorities(roles);
	}
	
	private ImmutableSet<GrantedAuthority> getAuthorities(Set<String> roles) {
		Builder<GrantedAuthority> builder = ImmutableSet.builder();
		for (String role : roles) {
			builder.add(new SimpleGrantedAuthority(role));
		}

		ImmutableSet<GrantedAuthority> authorities = builder.build();
		return authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}


	public Lingue getLingua() {
		return lingua;
	}

	public Locale getLocale() {
		Locale locale = null;
		switch (lingua){
			case DE:
				locale = Locale.GERMAN;
				break;
			case IT:
				locale = Locale.ITALIAN;
				break;
			case EN:
			default:
				locale = Locale.ENGLISH;
				break;
		}
		return locale;
	}

	
}
