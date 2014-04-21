package org.scuola247.desktop.config;
 
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import org.scuola247.desktop.security.Lingue;
import org.scuola247.desktop.security.Utente;
import org.scuola247.desktop.security.UtenteDettagli;
import org.scuola247.desktop.service.UserSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
 
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement ruoli_utente = null;
        Set<String> roles = new HashSet<>();
        try {
			conn = DataHelper.myConnection(username, password);
			conn.setAutoCommit(false);
			ruoli_utente = conn.prepareCall("{ ? = call rolnames_by_session_user() }");
			ruoli_utente.registerOutParameter(1, Types.OTHER);
			
			ruoli_utente.execute();
			
			rs = (ResultSet) ruoli_utente.getObject(1);
			
			roles.add("public");	// sono tutti abilitati ai ruoli pubblici
			while (rs.next()){
				roles.add(rs.getString(1));
			}
			conn.commit();
		} catch (SQLException e) {
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			String sqlState = e.getSQLState();
			if ("28P01".equals(sqlState)){
				throw new BadCredentialsException(String.format("SQLState: %s - %s", sqlState, e.getMessage()), e);
			}
			else{
				throw new BadCredentialsException(String.format("SQLState: %s - %s", sqlState, e.getMessage()), e);
			}
		}
        finally{

        	if (rs != null){
            	try{
            		rs.close();
	        	}
	        	catch (SQLException e){
	        		throw new AuthenticationServiceException(e.getMessage(), e);
	        	}
        	}
        	if (ruoli_utente != null){
        		try {
					ruoli_utente.close();
				} catch (SQLException e) {
					throw new AuthenticationServiceException(e.getMessage(), e);
				}
        	}
        	if (conn != null){
        		try {
        			conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
					throw new AuthenticationServiceException(e.getMessage(), e);
				}
        	}
        }
        
		UserSettings settings = new UserSettings();
        Utente utente = new Utente(username, password, true, true, Lingue.IT, settings, roles);
        
        UtenteDettagli utenteDettagli = new UtenteDettagli(utente);
        
        
        return new UsernamePasswordAuthenticationToken(utenteDettagli, null, utenteDettagli.getAuthorities());
    }
 
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}