package org.scuola247.desktop.service;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.scuola247.desktop.beans.Institute;
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

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(STORE_READ)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional(readOnly = true)
	public ExtDirectStoreResult<Institute> read(ExtDirectStoreReadRequest request, Locale locale) throws NamingException, SQLException {
/*
		JPQLQuery query = new JPAQuery(entityManager).from(QAccessLog.accessLog);

		if (!request.getFilters().isEmpty()) {
			StringFilter userNameFilter = (StringFilter) request.getFilters().iterator().next();
			String userName = userNameFilter.getValue();
			query.where(QAccessLog.accessLog.userName.startsWithIgnoreCase(userName));
		}

		QueryUtil.addPagingAndSorting(query, request, AccessLog.class, QAccessLog.accessLog,
				Collections.<String, String> emptyMap(), Collections.singleton("browser"));

		SearchResults<AccessLog> searchResult = query.listResults(QAccessLog.accessLog);

		PeriodFormatter minutesAndSeconds = new PeriodFormatterBuilder()
				.appendMinutes()
				.appendSuffix(" " + messageSource.getMessage("minute", null, locale),
						" " + messageSource.getMessage("minutes", null, locale))
				.appendSeparator(" " + messageSource.getMessage("and", null, locale) + " ")
				.printZeroRarelyLast()
				.appendSeconds()
				.appendSuffix(" " + messageSource.getMessage("second", null, locale),
						" " + messageSource.getMessage("seconds", null, locale)).toFormatter();

		for (AccessLog accessLog : searchResult.getResults()) {
			if (accessLog.getLogIn() != null && accessLog.getLogOut() != null) {
				Duration duration = new Duration(accessLog.getLogIn(), accessLog.getLogOut());
				Period period = new Period(duration, PeriodType.forFields(new DurationFieldType[] {
						DurationFieldType.minutes(), DurationFieldType.seconds() }));
				accessLog.setDuration(minutesAndSeconds.print(period));
			}

		}
*/
		
		
		
		List<Institute> ans = new LinkedList<>();
		
		Context ctx = null;
		DataSource ds = null;
		Connection conn = null;
		ResultSet rs = null;
	    PreparedStatement by_descrizione = null;
	    PreparedStatement find = null;
	    PreparedStatement update = null;
	    PreparedStatement insert = null;
	    PreparedStatement delete = null;
		
		// prendi connessione
		ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/desktop");
		conn = ds.getConnection("fol@fulcro.net","password");
		conn.setAutoCommit(false);

		// crea prepared statement
		//find = conn.prepareStatement("SELECT istituti_find(?)");
		by_descrizione = conn.prepareStatement("SELECT istituti_by_descrizione(?)");
		//update = conn.prepareStatement("{ SELECT istituti_update(?, ?, ?, ?, ?, ?) }");
		//insert = conn.prepareStatement("{ SELECT istituti_find(?, ?, ?, ?) }");
		//delete = conn.prepareStatement("{ SELECT istituti_delete(?, ?) }");
	
		// compila prepare statement
		//find.setInt(1, 1);

		by_descrizione.setString(1, "%");
		// esegui query
		rs = by_descrizione.executeQuery();
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

}
