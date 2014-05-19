package org.scuola247.desktop.service;


import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.naming.NamingException;

import org.apache.commons.codec.binary.Base64;
import org.postgresql.util.PSQLException;
import org.scuola247.desktop.beans.DocenteIstituto;
import org.scuola247.desktop.beans.FirmaClasseDocente;
import org.scuola247.desktop.beans.LezioneDocenteClasseMateria;
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
public class DocenteService {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<DocenteIstituto> listDocenteIstituto(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<DocenteIstituto> ans = new LinkedList<>();
		Integer filtroIstituto = (Integer)request.getParams().get("institute");

		Long docente;
		String nome_cognome, cognome, nome, codice_fiscale, foto_miniatura;
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement docenti_by_istituto = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			docenti_by_istituto = conn.prepareCall("{ ? = call docenti_by_istituto(?) }");
			// compila prepare statement
			docenti_by_istituto.registerOutParameter(1, Types.OTHER);

			docenti_by_istituto.setLong(2, filtroIstituto);
	
			docenti_by_istituto.execute();
			rs = (ResultSet) docenti_by_istituto.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				docente = rs.getLong(1);
				cognome = rs.getString(2);
				nome = rs.getString(3);
				nome_cognome = nome + " " + cognome;
				codice_fiscale = rs.getString(4);
				
				byte[] data = rs.getBytes(5);
				foto_miniatura = Base64.encodeBase64String(data);
				if (foto_miniatura == null){
					foto_miniatura = "";
				}
				
				ans.add(new DocenteIstituto(docente, nome_cognome, cognome, nome, codice_fiscale, foto_miniatura));
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
			if (docenti_by_istituto != null){
				docenti_by_istituto.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	
	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<FirmaClasseDocente> listFirmaClasseDocente(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<FirmaClasseDocente> ans = new LinkedList<>();
		Integer filtroClasse = (Integer)request.getParams().get("classe");
		Integer filtroDocente = (Integer)request.getParams().get("docente");

		Date data_firma, ora_firma;
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement firme_docente_classe = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			firme_docente_classe = conn.prepareCall("{ ? = call firme_by_docente_classe(?,?) }");
			// compila prepare statement
			firme_docente_classe.registerOutParameter(1, Types.OTHER);

			firme_docente_classe.setLong(2, filtroDocente);
			firme_docente_classe.setLong(3, filtroClasse);
	
			firme_docente_classe.execute();
			rs = (ResultSet) firme_docente_classe.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				data_firma = rs.getDate(1);
				ora_firma = rs.getTime(2);
			
				ans.add(new FirmaClasseDocente(data_firma, ora_firma));
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
			if (firme_docente_classe != null){
				firme_docente_classe.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<LezioneDocenteClasseMateria> listLezioneDocenteClasseMateria(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<LezioneDocenteClasseMateria> ans = new LinkedList<>();
		Integer filtroClasse = (Integer)request.getParams().get("classe");
		Integer filtroDocente = (Integer)request.getParams().get("docente");
		Integer filtroMateria = (Integer)request.getParams().get("materia");

		boolean supplenza;
		Date giorno, dalle, alle;
		String descrizione;

		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement lezione_docente_classe_materia = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			lezione_docente_classe_materia = conn.prepareCall("{ ? = call lezioni_by_docente_classe_materia(?,?,?) }");
			// compila prepare statement
			lezione_docente_classe_materia.registerOutParameter(1, Types.OTHER);

			lezione_docente_classe_materia.setLong(2, filtroDocente);
			lezione_docente_classe_materia.setLong(3, filtroClasse);
			lezione_docente_classe_materia.setLong(4, filtroMateria);
	
			lezione_docente_classe_materia.execute();
			rs = (ResultSet) lezione_docente_classe_materia.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				supplenza = rs.getBoolean(1);
				giorno = rs.getDate(2);
				dalle = rs.getTime(3);
				alle = rs.getTime(4);
				descrizione = rs.getString(5);
				
				ans.add(new LezioneDocenteClasseMateria(supplenza, giorno, dalle, alle, descrizione));
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
			if (lezione_docente_classe_materia != null){
				lezione_docente_classe_materia.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	
}
