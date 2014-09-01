package org.scuola247.desktop.util;

import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;
import org.scuola247.desktop.beans.DirectResponse;
import org.scuola247.desktop.security.Utente;
import org.scuola247.desktop.security.UtenteDettagli;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Util {

	private Util() {
		// do not instantiate this class
	}
	
	public static DirectResponse getPSQLExceptionDetail(PSQLException e){
		DirectResponse resp = new DirectResponse();
		resp.setOk(false);
		ServerErrorMessage exceptionDetail = e.getServerErrorMessage();
		resp.setErrorCode(exceptionDetail.getSQLState());
		resp.setErrorMessage(exceptionDetail.getMessage());
		resp.setErrorDetail(exceptionDetail.getDetail());
		resp.setErrorHint(exceptionDetail.getHint());
		return resp;
	}
	
/*
	public static void signin(User user) {
		JpaUserDetails principal = new JpaUserDetails(user);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, null,
				principal.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(token);
	}
*/
	public static void signin(Utente utente) {
		UtenteDettagli principal = new UtenteDettagli(utente);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, null,
				principal.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(token);
	}

	
	public static UtenteDettagli getLoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UtenteDettagli) {
			return (UtenteDettagli) principal;
		}
		return null;
	}
	
	/*
	public static JpaUserDetails getLoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof JpaUserDetails) {
			return (JpaUserDetails) principal;
		}
		return null;
	}
	*/

	public static boolean hasRole(String role) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return false;
		}

		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return false;
		}

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if (role.equals(auth.getAuthority())) {
				return true;
			}
		}

		return false;
	}

}
