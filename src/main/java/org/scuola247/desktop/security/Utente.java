package org.scuola247.desktop.security;

import java.util.Set;

import org.scuola247.desktop.service.UserSettings;

public class Utente {
	
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	private boolean locked;
	
	private Lingue lingua;

	private UserSettings settings;
	
	private Set<String> roles;
	
	public Utente() {
		super();
	}

	public Utente(String username, String password, boolean enabled, boolean locked, Lingue locale, UserSettings settings, Set<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.locked = locked;
		this.lingua = locale;
		this.settings = settings;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Lingue getLingua() {
		return lingua;
	}

	public void setLingua(Lingue lingua) {
		this.lingua = lingua;
	}

	public UserSettings getSettings() {
		return settings;
	}

	public void setSettings(UserSettings settings) {
		this.settings = settings;
	}
	
	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
