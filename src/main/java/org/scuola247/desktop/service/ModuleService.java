package org.scuola247.desktop.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;

import org.scuola247.desktop.security.UtenteDettagli;
import org.scuola247.desktop.util.Util;

import com.google.common.collect.ImmutableList;

@Service
public class ModuleService {

	@Autowired
	private MessageSource messageSource;

	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ)
	@PreAuthorize("isAuthenticated()")
	public ImmutableList<Module> read(Locale locale) {
		UtenteDettagli user = Util.getLoggedInUser();
		if (user != null) {
			ImmutableList.Builder<Module> builder = ImmutableList.builder();

			if (Util.hasRole("gestori")) {
				builder.add(new Submenu(messageSource.getMessage("system", null, locale), "settings", "system"));
				builder.add(new Module("Desktop.view.UsersWindow", messageSource.getMessage("user", null, locale),"users", true, "system"));
				builder.add(new Module("Desktop.view.LoggingEventsWindow", messageSource.getMessage("logevents", null,locale), "loggingevents", true, "system"));
				builder.add(new Module("Desktop.view.AccessLogWindow", messageSource.getMessage("accesslog", null,locale), "accesslog", true, "system"));
				builder.add(new Module("Desktop.view.ConfigurationWindow", messageSource.getMessage("configuration",null, locale), "configuration", false, "system"));
				builder.add(new Module("Desktop.view.module.Institutes", messageSource.getMessage("institutes", null, locale), "institutes", true));
			}
			
			builder.add(new Module("Desktop.view.Feedback", messageSource.getMessage("feedback", null, locale), "feedback", true));
			//builder.add(new Module("Desktop.view.Settings", messageSource.getMessage("settings", null, locale), "settings", true));
			builder.add(new Module("Desktop.view.module.OnlineUsers", messageSource.getMessage("onlineusers", null, locale), "onlineusers", true));
			builder.add(new Module("Desktop.view.module.Notepad", messageSource.getMessage("notepad", null, locale), "notepad", true));
/*			builder.add(new Module("Desktop.view.module.TabWindow", messageSource.getMessage("tabs", null, locale), "tabs", false)); */
			builder.add(new Module("Desktop.view.module.GridWindow", messageSource.getMessage("grid", null, locale), "grid", true));
			builder.add(new Module("Desktop.view.module.SystemStatus", messageSource.getMessage("systemstatus", null, locale), "systemstatus", true, "system"));
			builder.add(new Module("Desktop.view.module.AssigningStudents", messageSource.getMessage("AssigningStudents", null, locale), "AssigningStudents", true));
			builder.add(new Module("Desktop.view.module.Ballots",  messageSource.getMessage("ballots", null, locale), "ballots", true));
			builder.add(new Module("Desktop.view.module.ClassRegister", messageSource.getMessage("class_register", null, locale), "class_register", true));
			builder.add(new Module("Desktop.view.module.Classes", messageSource.getMessage("classes", null, locale), "classes", true));
			builder.add(new Module("Desktop.view.module.ClosingSchoolYear", messageSource.getMessage("closing_school_year", null, locale), "closing_school_year", true));
			builder.add(new Module("Desktop.view.module.EducationPaths", messageSource.getMessage("education_paths", null, locale), "education_paths", true));
			builder.add(new Module("Desktop.view.module.EducationSubjects", messageSource.getMessage("education_subjects", null, locale), "education_subjects", true));
			builder.add(new Module("Desktop.view.module.Metrics", messageSource.getMessage("metrics", null, locale), "metrics", true));
			builder.add(new Module("Desktop.view.module.OpeningSchoolYear", messageSource.getMessage("opening_school_year", null, locale), "opening_school_year", true));
			builder.add(new Module("Desktop.view.module.People", messageSource.getMessage("people", null, locale), "people", true));
			builder.add(new Module("Desktop.view.module.SchoolYears", messageSource.getMessage("school_years", null, locale), "school_years", true));
			builder.add(new Module("Desktop.view.module.Skills", messageSource.getMessage("skills", null, locale), "skills", true));
			builder.add(new Module("Desktop.view.module.StudentLogbook", messageSource.getMessage("student_logbook", null, locale), "student_logbook", true));
			if (Util.hasRole("docenti") || Util.hasRole("dirigenti") || Util.hasRole("gestori")) {
				builder.add(new Module("Desktop.view.module.TeacherRegister", messageSource.getMessage("teacher_register", null, locale), "teacher_register", true));
			}

			return builder.build();
		}

		return ImmutableList.of();

	}
}
