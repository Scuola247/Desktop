package org.scuola247.desktop.service;


import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.io.IOException;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.naming.NamingException;

import org.joda.time.DateTime;
import org.postgresql.util.PSQLException;
import org.scuola247.desktop.beans.AlunnoClasse;
import org.scuola247.desktop.beans.DirectResponse;
import org.scuola247.desktop.beans.GrigliaValutazioneColonna;
import org.scuola247.desktop.beans.GrigliaValutazioneRiga;
import org.scuola247.desktop.beans.ValutazioniResponse;
import org.scuola247.desktop.config.DataHelper;
import org.scuola247.desktop.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
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
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<GrigliaValutazioneColonna> griglia_valutazioni_colonne_by_classe_docente_materia(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<GrigliaValutazioneColonna> ans = new LinkedList<>();
		Map<String, Object> requestParams = request.getParams();
		Integer filtroClasse = (Integer)requestParams.get("classe");
		Integer filtroDocente = (Integer)requestParams.get("docente");
		Integer filtroMateria = (Integer)requestParams.get("materia");
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement colonneValutazioni = null;
	    
		Date giorno;
		long tipo_voto;
		String tipo_voto_descrizione;
		long argomento;
		String argomento_descrizione;
		long metrica;
		String metrica_descrizione;
				
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			colonneValutazioni = conn.prepareCall("{ ? = call griglia_valutazioni_colonne_by_classe_docente_materia(?, ?, ?) }");
			// compila prepare statement
			colonneValutazioni.registerOutParameter(1, Types.OTHER);
	
			colonneValutazioni.setLong(2, filtroClasse);
			colonneValutazioni.setLong(3, filtroDocente);
			colonneValutazioni.setLong(4, filtroMateria);
	
			colonneValutazioni.execute();
			rs = (ResultSet) colonneValutazioni.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				
				
				giorno = rs.getDate(1);
				tipo_voto = rs.getLong(2);
				tipo_voto_descrizione = rs.getString(3);
				argomento = rs.getLong(4);
				argomento_descrizione = rs.getString(5);
				metrica = rs.getLong(6);
				metrica_descrizione = rs.getString(7);
				
				ans.add(new GrigliaValutazioneColonna(giorno, tipo_voto, tipo_voto_descrizione, argomento, argomento_descrizione, metrica, metrica_descrizione));
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
			if (colonneValutazioni != null){
				colonneValutazioni.close();
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
	public ExtDirectStoreResult<GrigliaValutazioneRiga> griglia_valutazioni_righe_by_classe_docente_materia(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<GrigliaValutazioneRiga> ans = new LinkedList<>();
		Map<String, Object> requestParams = request.getParams();
		Integer filtroClasse = (Integer)requestParams.get("classe");
		Integer filtroDocente = (Integer)requestParams.get("docente");
		Integer filtroMateria = (Integer)requestParams.get("materia");

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement valutazioni_stm = null;
	    
		long alunno;
		String cognome;
		String nome;
		int assenze;
		int ritardi;
		int uscite;
		int fuori_classe;
		int note;
		int mancanze;
		String condotta;
		Array rvArray;
		Long[] rv = null;
		Array valutazioneArray;
		Long[] valutazioni = null;
		Array votoArray;
		Long[] voto = null;
				
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
		    valutazioni_stm = conn.prepareStatement("select alunno, cognome, nome, assenze, ritardi, uscite, fuori_classe, note, mancanze, condotta, rvs, valutazioni, voti from griglia_valutazioni_righe_by_classe_docente_materia(?,?,?)");
			// compila prepare statement
	
		    valutazioni_stm.setLong(1, filtroClasse);
		    valutazioni_stm.setLong(2, filtroDocente);
		    valutazioni_stm.setLong(3, filtroMateria);
	
			rs = valutazioni_stm.executeQuery();
			// ottenuto il result set
			while (rs.next()) {
				int i = 1;
				alunno = rs.getLong(i++);
				cognome = rs.getString(i++);
				nome = rs.getString(i++);
				assenze = rs.getInt(i++);
				ritardi = rs.getInt(i++);
				uscite = rs.getInt(i++);
				fuori_classe = rs.getInt(i++);
				note = rs.getInt(i++);
				mancanze = rs.getInt(i++);
				condotta = rs.getString(i++);
				
				rvArray = rs.getArray(i++);
				valutazioneArray = rs.getArray(i++);
				votoArray = rs.getArray(i++);
				
				if (rvArray != null){
					rv = (Long[])rvArray.getArray();
					valutazioni = (Long[])valutazioneArray.getArray();
					voto = (Long[])votoArray.getArray();
				}
				
				GrigliaValutazioneRiga grigliaValutazioneRiga = new GrigliaValutazioneRiga(alunno, cognome, nome, assenze, ritardi, uscite, fuori_classe, note, mancanze, condotta );
				
				//Recupero la parte variabile
				
				int posizioneVoto = 1;
				if (rvArray != null){
					for (int j = 0; j < valutazioni.length; j++){
						grigliaValutazioneRiga.setValutazione(posizioneVoto++, rv[j], valutazioni[j], voto[j]);
					}
				}
				
				ans.add(grigliaValutazioneRiga);
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
			if (valutazioni_stm != null){
				valutazioni_stm.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	
	@ExtDirectMethod(STORE_MODIFY)
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional
	public ExtDirectStoreResult<GrigliaValutazioneRiga> update_valutazione(GrigliaValutazioneRiga rigaValutazione, Locale locale) throws NamingException, SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement upd = null;
	    /*
	    conn = DataHelper.myConnection();
		// crea prepared statement
		
	    upd = conn.prepareCall("{ ? = call istituti_upd(?,?,?,?,?,?) }");

		upd.registerOutParameter(1,Types.BIGINT);
		
		upd.setLong(2, institute.getRv());
		upd.setLong(3, institute.getIstituto());
		upd.setString(4, institute.getDescrizione());
		upd.setString(5, institute.getCodice_meccanografico());
		upd.setString(6, institute.getMnemonico());
		upd.setBoolean(7, institute.isEsempio());
		try{
			upd.execute();
						
			if (upd.getUpdateCount() > 0){
				// ha aggiornato qualcosa
			}
			institute.setRv(upd.getLong(1));
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
//			throw e;
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
	     */		
		List<GrigliaValutazioneRiga> valutazioneList = new LinkedList<>();
		if (errorMessage == null){
			//TODO:valutazioneList.add(institute);
		}
		ExtDirectStoreResult<GrigliaValutazioneRiga> ans = new ExtDirectStoreResult<>(valutazioneList.size(), valutazioneList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}
	
	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('Pubblico')")
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
	
	@ExtDirectMethod
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
    public DirectResponse valutazioni_ins(
			Long rv,  
			Long valutazione, 
			Long classe,
		    Long alunno,
		    Long materia,
		    Long tipo_voto,
		    Long argomento,
		    Long voto,
		    String giudizio,
		    Boolean privata,
		    Long docente,
		    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") DateTime giorno)
            throws IOException, SQLException {
		DirectResponse resp = null;
		Connection conn = null;
		CallableStatement stsm = null;
		
		
		Long newRv = null;
		Long newValutazione = null;

		conn = DataHelper.myConnection();
		// crea prepared statement

		if (rv == null){
			stsm = conn.prepareCall("{call valutazioni_ins(?,?,?,?,?,?,?,?,?,?,?,?) }");
	
			stsm.registerOutParameter(1,Types.BIGINT);
			stsm.registerOutParameter(2,Types.BIGINT);
	
			stsm.setLong(3, classe);
			stsm.setLong(4, alunno);
			stsm.setLong(5, materia);
			stsm.setLong(6, tipo_voto);
			stsm.setLong(7, argomento);
			stsm.setLong(8, voto);
			stsm.setString(9, giudizio);
			stsm.setBoolean(10, privata);
			stsm.setLong(11, docente);
			stsm.setDate(12, new java.sql.Date(giorno.getMillis()));
			
			try{
				stsm.execute();
	
				newRv = stsm.getLong(1);
				newValutazione = stsm.getLong(2);
			}
			catch (PSQLException e){
				Logger logger = LoggerFactory.getLogger(getClass());
				logger.error(e.getMessage(), e);
				//			throw e;
				resp = Util.getPSQLExceptionDetail(e);
			}
			finally{
				if (stsm != null){
					stsm.close();
				}
				if (conn != null){
					conn.close();
				}
			}
		}
		else{
			stsm = conn.prepareCall("{? = call valutazioni_upd_voto(?,?,?) }");
			
			stsm.registerOutParameter(1,Types.BIGINT);
	
			stsm.setLong(2, rv);
			stsm.setLong(3, valutazione);
			stsm.setLong(4, voto);
			
			try{
				stsm.execute();
	
				newRv = stsm.getLong(1);
				newValutazione = valutazione;
			}
			catch (PSQLException e){
				Logger logger = LoggerFactory.getLogger(getClass());
				logger.error(e.getMessage(), e);
				//			throw e;
				
				resp = Util.getPSQLExceptionDetail(e);
			}
			finally{
				if (stsm != null){
					stsm.close();
				}
				if (conn != null){
					conn.close();
				}
			}
		}
		if (resp == null){
			resp = new DirectResponse();
			resp.setOk(true);
			resp.setPayload(new ValutazioniResponse(newRv, newValutazione));
		}
    	return resp;
    }
	
	@ExtDirectMethod
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
    public DirectResponse valutazioni_del(
			Long rv,  
			Long valutazione)
            throws IOException, SQLException {
		DirectResponse resp = null;
		Connection conn = null;
		CallableStatement stsm = null;

		conn = DataHelper.myConnection();
		// crea prepared statement

		stsm = conn.prepareCall("{call valutazioni_del(?,?) }");
		stsm.setLong(1, rv);
		stsm.setLong(2, valutazione);
		
		try{
			stsm.execute();
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			//			throw e;
			resp = Util.getPSQLExceptionDetail(e);
		}
		finally{
			if (stsm != null){
				stsm.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		if (resp == null){
			if (resp == null){
				resp = new DirectResponse();
				resp.setOk(true);
			}
		}
    	return resp;
    }
	
	@ExtDirectMethod
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
    public Map<String, Object> valutazioni_sel(Long valutazione)
            throws IOException, SQLException {
		Map<String,Object> ans = new HashMap<>();
		String errorMessage = null;
		Connection conn = null;
		CallableStatement stsm = null;

		conn = DataHelper.myConnection();
		// crea prepared statement

		stsm = conn.prepareCall("{call valutazioni_sel(?,?,?,?,?) }");
		stsm.registerOutParameter(1, Types.BIGINT);
		stsm.registerOutParameter(3, Types.VARCHAR);
		stsm.registerOutParameter(4, Types.BOOLEAN);
		stsm.registerOutParameter(5, Types.BOOLEAN);
		
		stsm.setLong(2, valutazione);
		
		Long rv;
		String giudizio;
		boolean privata;
		boolean nota;
		
		try{
			stsm.execute();
			rv = stsm.getLong(1);
			giudizio = stsm.getString(3);
			privata = stsm.getBoolean(4);
			nota = stsm.getBoolean(5);
			ans.put("rv", rv);
			ans.put("giudizio", giudizio);
			ans.put("privata", privata);
			ans.put("nota", nota);
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			//			throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (stsm != null){
				stsm.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		if (errorMessage == null){
			ans.put("status","OK");
		}
		else {
			ans.put("status", "KO," + errorMessage);
		}
    	return ans;
    }

	@ExtDirectMethod
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
    public Map<String, Object> valutazioni_upd(Long rv, Long valutazione, String giudizio, boolean privata, boolean nota)
            throws IOException, SQLException {
		Map<String,Object> ans = new HashMap<>();
		String errorMessage = null;
		Connection conn = null;
		CallableStatement stsm = null;

		conn = DataHelper.myConnection();
		// crea prepared statement

		stsm = conn.prepareCall("{? = call valutazioni_upd(?,?,?,?,?) }");
		stsm.registerOutParameter(1, Types.BIGINT);
		
		stsm.setLong(2, rv);
		stsm.setLong(3, valutazione);
		stsm.setString(4, giudizio);
		stsm.setBoolean(5, privata);
		stsm.setBoolean(6, nota);
		
		Long rvOut;
		
		try{
			stsm.execute();
			rvOut = stsm.getLong(1);
			ans.put("rv", rvOut);
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			//			throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (stsm != null){
				stsm.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		if (errorMessage == null){
			ans.put("status","OK");
		}
		else {
			ans.put("status", "KO," + errorMessage);
		}
    	return ans;
    }
	
	
	
	
}
