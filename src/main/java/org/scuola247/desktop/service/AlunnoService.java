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
public class AlunnoService {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('public')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<AlunnoEx> listClasseAlunniEx(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<AlunnoEx> ans = new LinkedList<>();
		Integer filtroClasse = (Integer)request.getParams().get("classe");

		Long classe, alunno, assenze, assenze_non_giustificate, ritardi, ritardi_non_giustificati, uscite, uscite_non_giustificate, fuori_classi, note;
		String foto_miniatura, codice_fiscale, nome, cognome, sesso, comune_nascita_descrizione;
		Date nato;
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement classe_alunni_ex = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			classe_alunni_ex = conn.prepareCall("{ ? = call classe_alunni_ex(?) }");
			// compila prepare statement
			classe_alunni_ex.registerOutParameter(1, Types.OTHER);
	
			classe_alunni_ex.setLong(2, filtroClasse);
	
			classe_alunni_ex.execute();
			rs = (ResultSet) classe_alunni_ex.getObject(1);
			// ottenuto il result set
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
				
				ans.add(new AlunnoEx(classe, alunno, foto_miniatura, codice_fiscale, nome, cognome, sesso, nato, comune_nascita_descrizione, assenze, assenze_non_giustificate, ritardi, ritardi_non_giustificati, uscite, uscite_non_giustificate, fuori_classi, note));
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
			if (classe_alunni_ex != null){
				classe_alunni_ex.close();
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
