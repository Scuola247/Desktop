package org.scuola247.desktop.web;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

//import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

//import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.scuola247.desktop.entity.LoggingEvent;
import org.scuola247.desktop.entity.LoggingEventException;
import org.scuola247.desktop.entity.LoggingEventProperty;
//import org.scuola247.desktop.entity.QLoggingEvent;
//import org.scuola247.desktop.entity.QLoggingEventException;
//
//import com.mysema.query.jpa.JPQLQuery;
//import com.mysema.query.jpa.impl.JPAQuery;

@Controller
public class LoggingEventExport {

//	@ - PersistenceContext
//	private EntityManager entityManager;

	@Autowired
	private MessageSource messageSource;

	@Transactional(readOnly = true)
	@RequestMapping(value = "/loggingEventExport.txt", method = RequestMethod.GET)
	@PreAuthorize("hasRole('gestori')")
	public void loggingEventExport(HttpServletResponse response, @RequestParam(required = false) final String level)
			throws Exception {

		response.setContentType("text/plain");
		response.addHeader("Content-disposition", "attachment;filename=logs.txt");

		String separator = new String(new char[140]).replace("\0", "=");
/*
		try (OutputStream out = response.getOutputStream(); PrintWriter pw = new PrintWriter(out)) {

			List<LoggingEvent> events;
			if (StringUtils.hasText(level)) {
				events = new JPAQuery(entityManager).from(QLoggingEvent.loggingEvent)
						.where(QLoggingEvent.loggingEvent.levelString.eq(level)).list(QLoggingEvent.loggingEvent);
			} else {
				events = new JPAQuery(entityManager).from(QLoggingEvent.loggingEvent).list(QLoggingEvent.loggingEvent);
			}

			for (LoggingEvent event : events) {
				String userName = "";
				String ip = "";

				Set<LoggingEventProperty> properties = event.getLoggingEventProperty();
				for (LoggingEventProperty prop : properties) {
					if ("userName".equals(prop.getId().getMappedKey())) {
						userName = prop.getMappedValue();
					} else if ("ip".equals(prop.getId().getMappedKey())) {
						ip = prop.getMappedValue();
					}
				}

				pw.println("Time   : " + new LocalDateTime(event.getTimestmp().longValue()));
				pw.println("User   : " + userName);
				pw.println("IP     : " + ip);
				pw.println("Level  : " + event.getLevelString());
				pw.println("Klasse : " + event.getCallerClass());
				pw.println("Methode: " + event.getCallerMethod());
				pw.println("Zeile  : " + event.getCallerLine());
				pw.println("Meldung: " + event.getFormattedMessage());

				JPQLQuery jpaQuery = new JPAQuery(entityManager);
				List<LoggingEventException> stacktrace = jpaQuery.from(QLoggingEventException.loggingEventException)
						.where(QLoggingEventException.loggingEventException.id.eventId.eq(event.getEventId()))
						.orderBy(QLoggingEventException.loggingEventException.id.i.asc())
						.list(QLoggingEventException.loggingEventException);

				if (!stacktrace.isEmpty()) {
					StringBuilder sb = new StringBuilder(300);
					for (LoggingEventException loggingEventException : stacktrace) {
						sb.append(loggingEventException.getTraceLine());
						sb.append('\n');
					}
					pw.println(sb);

				}
				pw.println(separator);

			}

		}
*/
	}

}
