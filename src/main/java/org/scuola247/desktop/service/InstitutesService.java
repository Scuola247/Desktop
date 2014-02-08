package org.scuola247.desktop.service;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public ExtDirectStoreResult<Institute> read(ExtDirectStoreReadRequest request, Locale locale) {
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
		
		// prendi connessione
		// crea prepared statement
		// compila prepare statement
		// esegui query
		// ottenuto il result set
		// for (){
		// ans.add(new Institute( .... ))
		// }
		
		
		ans.add(new Institute(new BigInteger("0"), "aaa", "aaa", "aaa", true));
		ans.add(new Institute(new BigInteger("0"), "bbb", "bbb", "bbb", true));
		ans.add(new Institute(new BigInteger("0"), "ccc", "ccc", "ccc", true));
		
		return new ExtDirectStoreResult<>(ans.size(), ans);

	}

}
