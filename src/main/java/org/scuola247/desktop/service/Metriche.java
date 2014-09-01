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
import org.scuola247.desktop.beans.Metrica;
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
public class Metriche {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Metrica> ByIstituto(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<Metrica> ans = new LinkedList<>();
		Integer filtroIstituto = (Integer)request.getParams().get("istituto");

		Long rv; 
		Long metrica; 
		String descrizione; 
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement metrica_by_istituto = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
		    metrica_by_istituto = conn.prepareCall("{ ? = call metriche_by_istituto(?) }");
			// compila prepare statement
		    metrica_by_istituto.registerOutParameter(1, Types.OTHER);
	
		    metrica_by_istituto.setLong(2, filtroIstituto);
	
		    metrica_by_istituto.execute();
			rs = (ResultSet) metrica_by_istituto.getObject(1);
			// ottenuto il result set
			
			while (rs.next()) {
				rv = rs.getLong(1); 
				metrica = rs.getLong(2);
				descrizione = rs.getString(3);
				
				ans.add(new Metrica(rv, metrica, descrizione));
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
			if (metrica_by_istituto != null){
				metrica_by_istituto.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
}
