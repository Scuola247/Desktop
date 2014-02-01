package org.scuola247.desktop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "ch.ralscha.extdirectspring", "org.scuola247.desktop.config", "org.scuola247.desktop.schedule",
		"org.scuola247.desktop.security", "org.scuola247.desktop.service", "org.scuola247.desktop.web" })
@PropertySource("classpath:/version.properties")
public class ComponentConfig {
	// nothing here
}