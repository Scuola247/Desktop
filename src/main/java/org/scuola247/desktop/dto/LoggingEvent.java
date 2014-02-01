package org.scuola247.desktop.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import org.scuola247.desktop.entity.LoggingEventException;
import org.scuola247.desktop.entity.LoggingEventProperty;
import org.scuola247.desktop.util.DateTimeSerializer;
import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;

@Model(value = "Desktop.model.LoggingEvent", readMethod = "loggingEventService.read", paging = true)
public class LoggingEvent {
	private long id;

	@ModelField(dateFormat = "Y-m-d H:i")
	private DateTime dateTime;

	private String message;

	private String level;

	private String callerClass;

	private String callerLine;

	private String ip;

	private String stacktrace;

	public LoggingEvent(org.scuola247.desktop.entity.LoggingEvent event) {
		this.id = event.getEventId();
		this.dateTime = new DateTime(event.getTimestmp().longValue());
		this.message = event.getFormattedMessage();
		this.level = event.getLevelString();
		this.callerClass = event.getCallerClass();
		this.callerLine = event.getCallerLine();

		Set<LoggingEventProperty> properties = event.getLoggingEventProperty();

		for (LoggingEventProperty prop : properties) {
			if ("ip".equals(prop.getId().getMappedKey())) {
				this.ip = prop.getMappedValue();
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		List<LoggingEventException> exceptionList;

		Set<LoggingEventException> exceptions = event.getLoggingEventException();
		if (exceptions != null) {
			exceptionList = Lists.newArrayList(exceptions);
			Collections.sort(exceptionList, new Comparator<LoggingEventException>() {

				@Override
				public int compare(LoggingEventException o1, LoggingEventException o2) {
					return o1.getId().getI() - o2.getId().getI();
				}
			});
		} else {
			exceptionList = Collections.emptyList();
		}

		for (LoggingEventException line : exceptionList) {
			sb.append(line.getTraceLine());
			sb.append("<br />");
		}

		this.stacktrace = sb.toString();

	}

	@JsonSerialize(using = DateTimeSerializer.class)
	public DateTime getDateTime() {
		return dateTime;
	}

	public String getMessage() {
		return message;
	}

	public String getLevel() {
		return level;
	}

	public String getCallerClass() {
		return callerClass;
	}

	public String getCallerLine() {
		return callerLine;
	}

	public String getIp() {
		return ip;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public long getId() {
		return id;
	}

}
