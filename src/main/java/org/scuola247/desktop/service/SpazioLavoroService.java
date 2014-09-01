package org.scuola247.desktop.service;


import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.naming.NamingException;

import org.postgresql.util.PSQLException;
import org.scuola247.desktop.beans.SpazioLavoro;
import org.scuola247.desktop.config.DataHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;


@Service
public class SpazioLavoroService {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	//@PreAuthorize("hasRole('Gestore')")
	@PreAuthorize("isAuthenticated()")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<SpazioLavoro> list(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<SpazioLavoro> ans = new LinkedList<>();
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement by_descrizione = null;
	    
		Long rv;
		Long spazio_lavoro;
		String descrizione;
		Long istituto, anno_scolastico, classe, materia, docente, famigliare, alunno;
		boolean spazio_lavoro_default;
		
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
		    
			// crea prepared statement
			by_descrizione = conn.prepareCall("{ ? = call spazi_lavoro_list() }");
						
			// compila prepare statement
			by_descrizione.registerOutParameter(1, Types.OTHER);
	
			by_descrizione.execute();
			rs = (ResultSet) by_descrizione.getObject(1);
			
			// ottenuto il result set
			while (rs.next()) {
				//rs.getMetaData().getColumnCount()
				rv = rs.getLong(1);
				spazio_lavoro = rs.getLong(2);
				istituto = rs.getLong(3);
				anno_scolastico = rs.getLong(4);
				classe = rs.getLong(5);
				if (rs.wasNull()){
					classe = null;
				}
				materia = rs.getLong(6);
				if (rs.wasNull()){
					materia = null;
				}
				docente = rs.getLong(7);
				if (rs.wasNull()){
					docente = null;
				}
				famigliare = rs.getLong(8);
				if (rs.wasNull()){
					famigliare = null;
				}
				alunno = rs.getLong(9);
				if (rs.wasNull()){
					alunno = null;
				}
				descrizione = rs.getString(10);
				spazio_lavoro_default = rs.getBoolean(11);
				
				ans.add(new SpazioLavoro(rv, spazio_lavoro, descrizione, istituto, anno_scolastico, classe, materia, docente, famigliare, alunno, spazio_lavoro_default));
			} 
			
	    }
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
		finally{
			if (rs != null){
				rs.close();
			}
			if (by_descrizione != null){
				by_descrizione.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	
	
	@ExtDirectMethod(STORE_MODIFY)
	//@PreAuthorize("hasRole('Gestore')")
	@PreAuthorize("isAuthenticated()")
	@Transactional
	public ExtDirectStoreResult<SpazioLavoro> ins(SpazioLavoro spazioLavoro, Locale locale) throws SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement isrt = null;

	    Long classe, materia, docente, famigliare, alunno;
	    
		Long newRv = null;
		Long newSpazioLavoro = null;
	    
		// crea prepared statement
		try{
			conn = DataHelper.myConnection();
		    
			isrt = conn.prepareCall("{call spazi_lavoro_ins(?,?,?,?,?,?,?,?,?,?) }");

			isrt.registerOutParameter(1,Types.BIGINT);
			isrt.registerOutParameter(2,Types.BIGINT);
			isrt.setString(3,spazioLavoro.getDescrizione());
			isrt.setLong(4, spazioLavoro.getIstituto());
			isrt.setLong(5, spazioLavoro.getAnno_scolastico());
			
			classe = spazioLavoro.getClasse();
			materia = spazioLavoro.getMateria();
			docente = spazioLavoro.getDocente();
			famigliare = spazioLavoro.getFamigliare();
			alunno = spazioLavoro.getAlunno();

			if (classe == null){
				isrt.setNull(6, Types.BIGINT);
			}
			else{
				isrt.setLong(6, classe);
			}
			
			if (materia == null){
				isrt.setNull(7, Types.BIGINT);
			}
			else{
				isrt.setLong(7, materia);
			}
			
			if (docente == null){
				isrt.setNull(8, Types.BIGINT);
			}
			else{
				isrt.setLong(8, docente);
			}
			
			if (famigliare == null){
				isrt.setNull(9, Types.BIGINT);
			}
			else{
				isrt.setLong(9, famigliare);
			}
			
			if (alunno == null){
				isrt.setNull(10, Types.BIGINT);
			}
			else{
				isrt.setLong(10, alunno);
			}
			isrt.execute();
			
			newRv = isrt.getLong(1);
			newSpazioLavoro = isrt.getLong(2);
			spazioLavoro.setRv(newRv);
			spazioLavoro.setSpazio_lavoro(newSpazioLavoro);
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			errorMessage = e.getMessage();
		}
		catch(Exception e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			errorMessage = e.getCause() + " - " + e.getMessage();
		}
		finally{
			if (isrt != null){
				isrt.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		
		List<SpazioLavoro> spazioLavoroList = new LinkedList<>();
		if (errorMessage == null){
			spazioLavoroList.add(spazioLavoro);
		}
		ExtDirectStoreResult<SpazioLavoro> ans = new ExtDirectStoreResult<>(spazioLavoroList.size(), spazioLavoroList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}
	
	@ExtDirectMethod(STORE_MODIFY)
	//@PreAuthorize("hasRole('Gestore')")
	@PreAuthorize("isAuthenticated()")
	@Transactional
	public ExtDirectStoreResult<SpazioLavoro> upd(SpazioLavoro spazioLavoro, Locale locale) throws SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement isrt = null;

	    Long classe, materia, docente, famigliare, alunno;
	    
		Long newRv = null;
	    
		// crea prepared statement
		try{
			conn = DataHelper.myConnection();
		    
			
			isrt = conn.prepareCall("{? = call spazi_lavoro_upd(?,?,?,?,?,?,?,?,?,?) }");

			isrt.registerOutParameter(1,Types.BIGINT);
			
			isrt.setLong(2, spazioLavoro.getRv());
			isrt.setLong(3, spazioLavoro.getSpazio_lavoro());
			isrt.setString(4,spazioLavoro.getDescrizione());
			isrt.setLong(5, spazioLavoro.getIstituto());
			isrt.setLong(6, spazioLavoro.getAnno_scolastico());
			
			classe = spazioLavoro.getClasse();
			materia = spazioLavoro.getMateria();
			docente = spazioLavoro.getDocente();
			famigliare = spazioLavoro.getFamigliare();
			alunno = spazioLavoro.getAlunno();
			
			if (classe == null){
				isrt.setNull(7, Types.BIGINT);
			}
			else{
				isrt.setLong(7, classe);
			}
			
			if (materia == null){
				isrt.setNull(8, Types.BIGINT);
			}
			else{
				isrt.setLong(8, materia);
			}
			
			if (docente == null){
				isrt.setNull(9, Types.BIGINT);
			}
			else{
				isrt.setLong(9, docente);
			}
			
			if (famigliare == null){
				isrt.setNull(10, Types.BIGINT);
			}
			else{
				isrt.setLong(10, famigliare);
			}
			
			if (alunno == null){
				isrt.setNull(11, Types.BIGINT);
			}
			else{
				isrt.setLong(11, alunno);
			}
			isrt.execute();
			
			newRv = isrt.getLong(1);
			spazioLavoro.setRv(newRv);
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			errorMessage = e.getMessage();
		}
		catch(Exception e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			errorMessage = e.getCause() + " - " + e.getMessage();
		}
		finally{
			if (isrt != null){
				isrt.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		
		List<SpazioLavoro> spazioLavoroList = new LinkedList<>();
		if (errorMessage == null){
			spazioLavoroList.add(spazioLavoro);
		}
		ExtDirectStoreResult<SpazioLavoro> ans = new ExtDirectStoreResult<>(spazioLavoroList.size(), spazioLavoroList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;

	}
	
	@ExtDirectMethod(STORE_MODIFY)
	//@PreAuthorize("hasRole('Gestore')")
	@PreAuthorize("isAuthenticated()")
	@Transactional
	public ExtDirectStoreResult<SpazioLavoro> del(SpazioLavoro spazioLavoro) throws NamingException, SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement del = null;
	    try{
		    conn = DataHelper.myConnection();
		    
		    // crea prepared statement
			del = conn.prepareCall("{call spazi_lavoro_del(?,?) }");
			
			del.setLong(1, spazioLavoro.getRv());
			del.setLong(2, spazioLavoro.getSpazio_lavoro());
			del.execute();
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
//			throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (del != null){
				del.close();
			}
			if (conn != null){
				conn.close();
			}
		}
	    List<SpazioLavoro> spazioLavoroList = new LinkedList<>();
		ExtDirectStoreResult<SpazioLavoro> ans = new ExtDirectStoreResult<>(spazioLavoroList.size(), spazioLavoroList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}

}
