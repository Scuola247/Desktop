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

import org.postgresql.util.PSQLException;
import org.scuola247.desktop.beans.Argomento;
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
public class Argomenti {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Argomento> ByMateriaClasse(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<Argomento> ans = new LinkedList<>();
		Integer filtroMateria = (Integer)request.getParams().get("materia");
		Integer filtroClasse = (Integer)request.getParams().get("classe");

		Long rv; 
		Long argomento; 
		String descrizione; 
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement argomenti_by_materia_classe = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
		    argomenti_by_materia_classe = conn.prepareCall("{ ? = call argomenti_by_materia_classe(?,?) }");
			// compila prepare statement
		    argomenti_by_materia_classe.registerOutParameter(1, Types.OTHER);
	
		    argomenti_by_materia_classe.setLong(2, filtroMateria);
		    argomenti_by_materia_classe.setLong(3, filtroClasse);
	
		    argomenti_by_materia_classe.execute();
			rs = (ResultSet) argomenti_by_materia_classe.getObject(1);
			// ottenuto il result set
			
			while (rs.next()) {
				rv = rs.getLong(1); 
				argomento = rs.getLong(2);
				descrizione = rs.getString(3);
				
				ans.add(new Argomento(rv, argomento, descrizione));
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
			if (argomenti_by_materia_classe != null){
				argomenti_by_materia_classe.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
}
