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
import org.scuola247.desktop.beans.Institute;
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
public class InstitutesService {


	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('public')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Institute> list(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<Institute> ans = new LinkedList<>();
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement istitutiList = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			istitutiList = conn.prepareCall("{ ? = call istituti_list() }");
			// compila prepare statement
			istitutiList.registerOutParameter(1, Types.OTHER);
	
			istitutiList.execute();
			rs = (ResultSet) istitutiList.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				ans.add(new Institute(rs.getLong(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6)));
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
			if (istitutiList != null){
				istitutiList.close();
			}
			if (conn != null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	
	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('gestori')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Institute> sel(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		List<Institute> ans = new LinkedList<>();
		
		String description = (String)request.getParams().get("description");
		
		if (description == null || description.length() == 0){
			description = "%";
		}
		else{
			description = "%" + description + "%";
		}
		
		Connection conn = null;
		ResultSet rs = null;
	    CallableStatement by_descrizione = null;
	    try{
		    conn = DataHelper.myConnection();
		    conn.setAutoCommit(false);
			// crea prepared statement
			by_descrizione = conn.prepareCall("{ ? = call istituti_by_descrizione(?) }");
			// compila prepare statement
			by_descrizione.registerOutParameter(1, Types.OTHER);
	
			by_descrizione.setString(2, description);
	
			by_descrizione.execute();
			rs = (ResultSet) by_descrizione.getObject(1);
			// ottenuto il result set
			while (rs.next()) {
				ans.add(new Institute(rs.getLong(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6)));
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
			if (by_descrizione != null){
				by_descrizione.close();
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
	public ExtDirectStoreResult<Institute> ins(Institute institute, Locale locale) throws SQLException {
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
		
		List<Institute> instituteList = new LinkedList<>();
		if (errorMessage == null){
			instituteList.add(institute);
		}
		ExtDirectStoreResult<Institute> ans = new ExtDirectStoreResult<>(instituteList.size(), instituteList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}
	*/
	/*
	@ExtDirectMethod(STORE_MODIFY)
	@PreAuthorize("hasRole('gestori')")
	@Transactional
	public ExtDirectStoreResult<Institute> upd(Institute institute, Locale locale) throws NamingException, SQLException {
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
		
		List<Institute> instituteList = new LinkedList<>();
		if (errorMessage == null){
			instituteList.add(institute);
		}
		ExtDirectStoreResult<Institute> ans = new ExtDirectStoreResult<>(instituteList.size(), instituteList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}
	*/
	
	@ExtDirectMethod(STORE_MODIFY)
	@PreAuthorize("hasRole('gestori')")
	@Transactional
	public ExtDirectStoreResult<Institute> del(Institute institute) throws NamingException, SQLException {
		String errorMessage = null;
		Connection conn = null;
	    CallableStatement del = null;
	    try{
		    conn = DataHelper.myConnection();
			// crea prepared statement
			del = conn.prepareCall("{call istituti_del(?,?) }");
			
			del.setLong(1 ,institute.getRv());
			del.setLong(2, institute.getIstituto());
			del.execute();
		
		}
		catch (PSQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
//			throw e;
			errorMessage = e.getMessage();
		}
		finally{
			if (del != null){
				del.close();
			}
			if (conn != null){
				conn.close();
			}
		}
	    List<Institute> instituteList = new LinkedList<>();
		ExtDirectStoreResult<Institute> ans = new ExtDirectStoreResult<>(instituteList.size(), instituteList, errorMessage == null);
		ans.setMessage(errorMessage);
		return ans;
	}


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
