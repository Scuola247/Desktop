package org.scuola247.desktop.service;


import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.naming.NamingException;

import org.apache.commons.codec.binary.Base64;
import org.postgresql.util.PSQLException;
import org.scuola247.desktop.beans.AlunnoClasse;
import org.scuola247.desktop.beans.AlunnoEx;
import org.scuola247.desktop.beans.ValutazioneAlunno;
import org.scuola247.desktop.config.DataHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;


@Service
public class ValutazioniService {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasAnyRole('docenti','dirigenti','gestori')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<ValutazioneAlunno> listValutazioniByClasse(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<ValutazioneAlunno> ans = new LinkedList<>();
		Integer filtroClasse = (Integer)request.getParams().get("classe");
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement cambia_il_mio_nome = null;
	    
	    Long alunno;
	    String foto_miniatura, cognome, nome;
	    
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			cambia_il_mio_nome = conn.prepareCall("{ ? = call classe_alunni_ex(?) }");
			// compila prepare statement
			cambia_il_mio_nome.registerOutParameter(1, Types.OTHER);
	
			cambia_il_mio_nome.setLong(2, filtroClasse);
	
			cambia_il_mio_nome.execute();
			rs = (ResultSet) cambia_il_mio_nome.getObject(1);
			// ottenuto il result set
			/*
			while (rs.next()) {

				classe = rs.getLong(1);
				alunno = rs.getLong(2);
				
				byte[] data = rs.getBytes(3);
				foto_miniatura = Base64.encodeBase64String(data);
				codice_fiscale = rs.getString(4);
				nome = rs.getString(5);
				cognome = rs.getString(6);
				sesso = rs.getString(7);
				nato = rs.getDate(8);
				comune_nascita_descrizione = rs.getString(9);
				assenze = rs.getLong(10);
				assenze_non_giustificate = rs.getLong(11);
				ritardi = rs.getLong(12);
				ritardi_non_giustificati = rs.getLong(13);
				uscite = rs.getLong(14);
				uscite_non_giustificate = rs.getLong(15);
				fuori_classi = rs.getLong(16);
				note = rs.getLong(17);
				*/
			for (int i = 0; i < 10; i++){
				alunno = 0L;
				foto_miniatura = "" + i;
				cognome = "" + i;
				nome = "" + i;
				
				ans.add(new ValutazioneAlunno(alunno, foto_miniatura, cognome, nome));
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
			if (cambia_il_mio_nome != null){
				cambia_il_mio_nome.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('public')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<AlunnoClasse> listAlunniByRuoloClasse(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<AlunnoClasse> ans = new LinkedList<>();
		Integer filtroClasse = (Integer)request.getParams().get("classe");
		Long alunno;
		String nome_cognome, cognome, nome, codice_fiscale, foto_miniatura;
		
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement alunno_by = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement e compila prepare statement
	    	alunno_by = conn.prepareCall("{ ? = call alunni_by_classe(?) }");
			alunno_by.setLong(2, filtroClasse);
	    	alunno_by.registerOutParameter(1, Types.OTHER);
	
			alunno_by.execute();
			rs = (ResultSet) alunno_by.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				alunno = rs.getLong(1);
				cognome = rs.getString(2);
				nome = rs.getString(3);
				nome_cognome = nome + " " + cognome;
				codice_fiscale = rs.getString(4);
				foto_miniatura = rs.getString(5);
				if (foto_miniatura == null){
					foto_miniatura = "";
				}
				ans.add(new AlunnoClasse(alunno, nome_cognome, cognome, nome, codice_fiscale, foto_miniatura));
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
			if (alunno_by != null){
				alunno_by.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	
}
