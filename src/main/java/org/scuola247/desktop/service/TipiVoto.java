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
import org.scuola247.desktop.beans.TipoVoto;
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
public class TipiVoto {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('Pubblico')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<TipoVoto> ByMateria(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<TipoVoto> ans = new LinkedList<>();
		Integer filtroMateria = (Integer)request.getParams().get("materia");

		Long rv; 
		Long tipo_voto; 
		String descrizione; 
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement tipo_voto_by_materia = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
		    tipo_voto_by_materia = conn.prepareCall("{ ? = call tipi_voto_by_materia(?) }");
			// compila prepare statement
		    tipo_voto_by_materia.registerOutParameter(1, Types.OTHER);
	
		    tipo_voto_by_materia.setLong(2, filtroMateria);
	
		    tipo_voto_by_materia.execute();
			rs = (ResultSet) tipo_voto_by_materia.getObject(1);
			// ottenuto il result set
			
			while (rs.next()) {
				rv = rs.getLong(1); 
				tipo_voto = rs.getLong(2);
				descrizione = rs.getString(3);
				
				ans.add(new TipoVoto(rv, tipo_voto, descrizione));
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
			if (tipo_voto_by_materia != null){
				tipo_voto_by_materia.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
}
