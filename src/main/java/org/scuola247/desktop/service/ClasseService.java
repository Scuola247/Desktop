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
import org.scuola247.desktop.beans.AnnoScolastico;
import org.scuola247.desktop.beans.Classe;
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
public class ClasseService {


	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('public')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Classe> list(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<Classe> ans = new LinkedList<>();
		Integer anno_scolastico = (Integer)request.getParams().get("anno_scolastico");
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement by_annoScolastico = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			by_annoScolastico = conn.prepareCall("{ ? = call classi_list(?) }");
			// compila prepare statement
			by_annoScolastico.registerOutParameter(1, Types.OTHER);
	
			by_annoScolastico.setLong(2, anno_scolastico);
	
			by_annoScolastico.execute();
			rs = (ResultSet) by_annoScolastico.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				ans.add(new Classe(rs.getLong(1), 
						rs.getLong(2), 
						rs.getLong(3),
						rs.getLong(4), 
						rs.getString(5), 
						rs.getLong(6),
						rs.getString(7), 
						rs.getLong(8)));
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
			if (by_annoScolastico != null){
				by_annoScolastico.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	
	/*
	@ExtDirectMethod(STORE_MODIFY)
	@PreAuthorize("hasRole('gestori')")
	@Transactional
	public ExtDirectStoreResult<AnnoScolastico> ins(AnnoScolastico annoScolastico, Locale locale) throws SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement isrt = null;

	    conn = DataHelper.myConnection();
		// crea prepared statement
		isrt = conn.prepareCall("{ ? = call istituti_ins(?,?,?,?) }");

		isrt.registerOutParameter(1,Types.BIGINT);

		isrt.setString(2, institute.getDescrizione());
		isrt.setString(3, institute.getCodice_meccanografico());
		isrt.setString(4, institute.getMnemonico());
		isrt.setBoolean(5, institute.isEsempio());

		try{
			isrt.execute();
			
			institute.setIstituto(isrt.getLong(1));
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
//			throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (isrt != null){
				isrt.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		
		List<AnnoScolastico> instituteList = new LinkedList<>();
		if (errorMessage == null){
			instituteList.add(institute);
		}
		ExtDirectStoreResult<AnnoScolastico> ans = new ExtDirectStoreResult<>(instituteList.size(), instituteList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}
	*/
	/*
	@ExtDirectMethod(STORE_MODIFY)
	@PreAuthorize("hasRole('gestori')")
	@Transactional
	public ExtDirectStoreResult<AnnoScolastico> upd(AnnoScolastico institute, Locale locale) throws NamingException, SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement upd = null;

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
		
		List<AnnoScolastico> instituteList = new LinkedList<>();
		if (errorMessage == null){
			instituteList.add(institute);
		}
		ExtDirectStoreResult<AnnoScolastico> ans = new ExtDirectStoreResult<>(instituteList.size(), instituteList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}
	*/
	
//	@ExtDirectMethod(STORE_MODIFY)
//	@PreAuthorize("hasRole('gestori')")
//	@Transactional
//	public ExtDirectStoreResult<AnnoScolastico> del(AnnoScolastico annoScolastico) throws NamingException, SQLException {
//		String errorMessage = null;
//		/*
//		Connection conn = null;
//	    CallableStatement del = null;
//	    try{
//		    conn = DataHelper.myConnection();
//			// crea prepared statement
//			del = conn.prepareCall("{call istituti_del(?,?) }");
//			
//			del.setLong(1 ,annoScolastico.getRv());
//			del.setLong(2, annoScolastico.getIstituto());
//			//del.execute();
//		
//		}
//		catch (PSQLException e){
//			Logger logger = LoggerFactory.getLogger(getClass());
//			logger.error(e.getMessage(), e);
////			throw e;
//			errorMessage = e.getMessage();
//		}
//		finally{
//			if (del != null){
//				del.close();
//			}
//			if (conn != null){
//				conn.close();
//			}
//		}
//		*/
//	    List<AnnoScolastico> instituteList = new LinkedList<>();
//		ExtDirectStoreResult<AnnoScolastico> ans = new ExtDirectStoreResult<>(instituteList.size(), instituteList, errorMessage == null);
//		ans.setMessage(errorMessage);
//		return ans;
//	}


/*
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY)
	public List<Person> update(List<Person> modifiedPersons) {
		List<Person> updatedRecords = Lists.newArrayList();
		for (Person modifiedPerson : modifiedPersons) {
			Person p = dataBean.findPerson(modifiedPerson.getId());
			if (p != null) {
				p.update(modifiedPerson);
				updatedRecords.add(p);
			}
		}
		return updatedRecords;
	}

	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY)
	public void destroy(List<Person> destroyPersons) {
		for (Person person : destroyPersons) {
			dataBean.deletePerson(person);
		}
	}
	 
	 */
	
	

}
