package org.scuola247.desktop.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.postgresql.ds.PGPoolingDataSource;
import org.scuola247.desktop.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private Environment environment;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MailService mailService;
	
	

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		mailService.configure();
		/*
		PGPoolingDataSource ds = null;
		try {
			ds = (PGPoolingDataSource)new InitialContext().lookup("scuola247ds");
		} catch (NamingException e) {
			
		}
		if (ds == null){
			ds = new PGPoolingDataSource();
			ds.setDataSourceName("scuola247ds");
			ds.setServerName("skyscraper");
			ds.setDatabaseName("scuola247");
			ds.setMaxConnections(10);
			
			try {
				new InitialContext().rebind("scuola247ds", ds);
			} catch (NamingException e) {
				Logger logger = LoggerFactory.getLogger(getClass());
				logger.error(e.getMessage(), e);
			}
		}
		*/
	}

}
