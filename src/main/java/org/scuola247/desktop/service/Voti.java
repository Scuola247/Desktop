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
import org.scuola247.desktop.beans.Voto;
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
public class Voti {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Voto> ByMetrica(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<Voto> ans = new LinkedList<>();
		Integer filtroMetrica = (Integer)request.getParams().get("metrica");

		Long rv; 
		Long voto; 
		Long metrica; 
		String descrizione; 
		String mnemonico; 
		int millesimi;
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement voti_by_metriche = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
		    voti_by_metriche = conn.prepareCall("{ ? = call voti_by_metrica(?) }");
			// compila prepare statement
		    voti_by_metriche.registerOutParameter(1, Types.OTHER);
	
		    voti_by_metriche.setLong(2, filtroMetrica);
	
		    voti_by_metriche.execute();
			rs = (ResultSet) voti_by_metriche.getObject(1);
			// ottenuto il result set
			
			ans.add(new Voto(-1L, -1L, filtroMetrica.longValue(), "", "-", 0));
			
			while (rs.next()) {
				rv = rs.getLong(1); 
				voto = rs.getLong(2);
				metrica = rs.getLong(3); 
				descrizione = rs.getString(4);
				mnemonico = rs.getString(5); 
				millesimi = rs.getInt(6);
				
				ans.add(new Voto(rv, voto, metrica, descrizione, mnemonico, millesimi));
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
			if (voti_by_metriche != null){
				voti_by_metriche.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
}
