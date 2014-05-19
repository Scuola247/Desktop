package org.scuola247.desktop.service;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Set;

import org.postgresql.util.PSQLException;
import org.scuola247.desktop.config.CustomAuthenticationProvider;
import org.scuola247.desktop.config.DataHelper;
import org.scuola247.desktop.security.UtenteDettagli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;

@Service
public class SpazioLavoroDefaultService {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@ExtDirectMethod
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
    public String setSpazioLavoroDefault(String spazioLavoro, boolean reloadRoles) throws IOException, SQLException {
		String errorMessage = null;
		Connection conn = null;

		conn = DataHelper.myConnection();
		// crea prepared statement
	    CallableStatement upd = null;

	    conn = DataHelper.myConnection();
		// crea prepared statement
		upd = conn.prepareCall("{call set_spazio_lavoro_default(?) }");

		long lSpazioLavoro = Long.parseLong(spazioLavoro);
		
		upd.setLong(1, lSpazioLavoro);

		try{
			upd.execute();
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
//				throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (upd != null){
				upd.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		if (errorMessage == null){
			//salvata l'impostazione spazio di lavoro
			
			
			if (reloadRoles){ 
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UtenteDettagli userDetail = (UtenteDettagli) principal;
		
				Set<String> roles = customAuthenticationProvider.loadUserRoles(null, null);
				
				userDetail.setRuoli(roles);
			
			}
			return "OK";
		}
		else{
			return errorMessage;
		}
    }

	@ExtDirectMethod
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public String getSessionUtente() throws IOException, SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement getSU = null;
	    long codiceUtente = -1;
		try{
			conn = DataHelper.myConnection();
			conn.setAutoCommit(false);
			// crea prepared statement
			getSU = conn.prepareCall("{? = call session_utente() }");
			getSU.registerOutParameter(1, Types.BIGINT);
			
			getSU.execute();

			codiceUtente = getSU.getLong(1);
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
//				throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (getSU != null){
				getSU.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		if (errorMessage == null){
			return String.valueOf(codiceUtente);
		}
		else{
			return errorMessage;
		}
	}
	
	@ExtDirectMethod
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public String getSessionPersona(Long istituto) throws IOException, SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement getSP = null;
	    long codicePersona = -1;
		try{
			conn = DataHelper.myConnection();
			conn.setAutoCommit(false);
			// crea prepared statement
			getSP = conn.prepareCall("{? = call session_persona(?) }");
			getSP.registerOutParameter(1, Types.BIGINT);
			
			getSP.setLong(2, istituto);
			
			getSP.execute();

			codicePersona = getSP.getLong(1);
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
//				throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (getSP != null){
				getSP.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		if (errorMessage == null){
			return String.valueOf(codicePersona);
		}
		else{
			return errorMessage;
		}
	}
}
