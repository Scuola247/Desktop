package org.scuola247.desktop.service;

import java.util.LinkedList;
import java.util.List;

//import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult;

import org.scuola247.desktop.dto.ConfigurationDto;
import org.scuola247.desktop.entity.Configuration;

@Service
@Lazy
public class AppConfigurationService {

//	@ - PersistenceContext
//	private EntityManager entityManager;

	@Autowired
	private MailService mailService;

	@ExtDirectMethod
	@PreAuthorize("hasRole('Gestore')")
	public void sendTestEmail(String to) {
		mailService.sendSimpleMessage(to, "TEST EMAIL FROM desktop@scuola247.org", "THIS IS A TEST MESSAGE");
	}

	@ExtDirectMethod(value = ExtDirectMethodType.FORM_LOAD)
	@PreAuthorize("hasRole('Gestore')")
	@Transactional(readOnly = true)
	public ConfigurationDto load() {

		ConfigurationDto dto = new ConfigurationDto();

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		ch.qos.logback.classic.Logger logger = lc.getLogger("org.scuola247.desktop");
		String level = logger != null && logger.getLevel() != null ? logger.getLevel().toString() : "ERROR";

		dto.setLogLevel(level);

		/*
		List<Configuration> configurations = new JPAQuery(entityManager).from(QConfiguration.configuration).list(
				QConfiguration.configuration);

		*/
		
		List<Configuration> configurations = new LinkedList<>();
		
		dto.setSender(read(ConfigurationKey.SMTP_SENDER, configurations));
		dto.setServer(read(ConfigurationKey.SMTP_SERVER, configurations));
		String port = read(ConfigurationKey.SMTP_PORT, configurations);
		if (port != null) {
			dto.setPort(Integer.valueOf(port));
		} else {
			dto.setPort(25);
		}
		dto.setUsername(read(ConfigurationKey.SMTP_USERNAME, configurations));
		dto.setPassword(read(ConfigurationKey.SMTP_PASSWORD, configurations));

		return dto;
	}

	private static String read(ConfigurationKey key, List<Configuration> list) {
		for (Configuration conf : list) {
			if (conf.getConfKey() == key) {
				return conf.getConfValue();
			}
		}
		return null;
	}

	@ExtDirectMethod(value = ExtDirectMethodType.FORM_POST)
	@PreAuthorize("hasRole('Gestore')")
	@Transactional
	public ExtDirectFormPostResult submit(ConfigurationDto data) {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		ch.qos.logback.classic.Logger logger = lc.getLogger("org.scuola247.desktop");
		Level level = Level.toLevel(data.getLogLevel());
		if (level != null) {
			logger.setLevel(level);
		}

		update(ConfigurationKey.SMTP_SENDER, data.getSender());
		update(ConfigurationKey.SMTP_SERVER, data.getServer());
		update(ConfigurationKey.SMTP_PORT, String.valueOf(data.getPort()));
		update(ConfigurationKey.SMTP_USERNAME, data.getUsername());
		update(ConfigurationKey.SMTP_PASSWORD, data.getPassword());

		mailService.configure();

		return new ExtDirectFormPostResult();
	}

	private void update(ConfigurationKey key, String value) {

		/*
		Configuration conf = new JPAQuery(entityManager).from(QConfiguration.configuration)
				.where(QConfiguration.configuration.confKey.eq(key)).singleResult(QConfiguration.configuration);

		if (StringUtils.isNotBlank(value)) {

			if (conf != null) {
				conf.setConfValue(value);
			} else {
				conf = new Configuration();
				conf.setConfKey(key);
				conf.setConfValue(value);
				entityManager.persist(conf);
			}

		} else {

			if (conf != null) {
				entityManager.remove(conf);
			}

		}
		*/
	}

}
