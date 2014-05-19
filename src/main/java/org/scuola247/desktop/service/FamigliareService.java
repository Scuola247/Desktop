package org.scuola247.desktop.service;


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

import org.apache.commons.codec.binary.Base64;
import org.postgresql.util.PSQLException;
import org.scuola247.desktop.beans.FamigliareClasse;
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
public class FamigliareService {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<FamigliareClasse> listFamigliariByRuoloClasse(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<FamigliareClasse> ans = new LinkedList<>();
		Integer filtroClasse = (Integer)request.getParams().get("classe");
		Long famigliare;
		String nome_cognome, cognome, nome, codice_fiscale, foto_miniatura;
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement alunno_by = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement e compila prepare statement
	    	alunno_by = conn.prepareCall("{ ? = call famigliari_by_classe(?) }");
			alunno_by.setLong(2, filtroClasse);
	    	alunno_by.registerOutParameter(1, Types.OTHER);
	    	
			alunno_by.execute();
			rs = (ResultSet) alunno_by.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				famigliare = rs.getLong(1);
				cognome = rs.getString(2);
				nome = rs.getString(3);
				nome_cognome = nome + " " + cognome;
				codice_fiscale = rs.getString(4);
				
				byte[] data = rs.getBytes(5);
				
				foto_miniatura = Base64.encodeBase64String(data);
				if (foto_miniatura == null){
					foto_miniatura = "";
				}
				ans.add(new FamigliareClasse(famigliare, nome_cognome, cognome, nome, codice_fiscale, foto_miniatura));
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
