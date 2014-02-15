package org.scuola247.desktop.service;


import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.scuola247.desktop.beans.Institute;
import org.scuola247.desktop.config.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ch.qos.logback.core.subst.Token.Type;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;


@Service
public class InstitutesService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Institute> read(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
		
		List<Institute> ans = new LinkedList<>();
		
		Connection conn = null;
		ResultSet rs = null;
	    // PreparedStatement by_descrizione = null;
	    CallableStatement by_descrizione = null;
		
	    conn = DataHelper.myConnection();
		// crea prepared statement
		by_descrizione = conn.prepareCall("{ ? = call istituti_by_descrizione(?) }");
		//by_descrizione = conn.prepareStatement("SELECT * FROM istituti_by_descrizione(?)");
		//update = conn.prepareStatement("{ SELECT istituti_update(?, ?, ?, ?, ?, ?) }");
		//delete = conn.prepareStatement("{ SELECT istituti_delete(?, ?) }");
	
		// compila prepare statement
		//find.setInt(1, 1);

		by_descrizione.registerOutParameter(1, Types.OTHER);

		by_descrizione.setString(2, "%");

		by_descrizione.execute();
		rs = (ResultSet) by_descrizione.getObject(1);
		// esegui query
		//rs = by_descrizione.executeQuery();
		// ottenuto il result set
		while (rs.next()) {
			Object o = rs.getObject(1);			
			ans.add(new Institute(rs.getLong(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6)));
		} 
		rs.close();
		by_descrizione.close();
		conn.close();
		return new ExtDirectStoreResult<>(ans.size(), ans);
	}
	


	 
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY)
	public Institute isrt(Institute newInstitute) throws SQLException {

		Connection conn = null;
	    CallableStatement isrt = null;

		conn = DataHelper.myConnection();
		// crea prepared statement
		isrt = conn.prepareCall("{ ? = call istituti_isrt(?,?,?,?) }");

		isrt.registerOutParameter(1,Types.BIGINT);

		isrt.setString(2, newInstitute.getDescrizione());
		isrt.setString(3, newInstitute.getCodice_meccanografico());
		isrt.setString(4, newInstitute.getMnemonico());
		isrt.setBoolean(5, newInstitute.isEsempio());

		isrt.execute();
		
		newInstitute.setIstituto(isrt.getLong(1));

		conn.close();
		return newInstitute;
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
