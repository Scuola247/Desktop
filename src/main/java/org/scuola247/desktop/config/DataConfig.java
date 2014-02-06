package org.scuola247.desktop.config;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.collect.Maps;

@Configuration
@EnableTransactionManagement
public class DataConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() throws NamingException {
		Context ctx = new InitialContext();
		return (DataSource) ctx.lookup("java:comp/env/jdbc/desktop");
		
		/*
		
		import java.sql.Connection;
		  import java.sql.ResultSet;
		  import java.sql.Statement;

		  import org.apache.tomcat.jdbc.pool.DataSource;
		  import org.apache.tomcat.jdbc.pool.PoolProperties;

		  public class SimplePOJOExample {

		      public static void main(String[] args) throws Exception {
		          PoolProperties p = new PoolProperties();
		          p.setUrl("jdbc:mysql://localhost:3306/mysql");
		          p.setDriverClassName("com.mysql.jdbc.Driver");
		          p.setUsername("root");
		          p.setPassword("password");
		          p.setJmxEnabled(true);
		          p.setTestWhileIdle(false);
		          p.setTestOnBorrow(true);
		          p.setValidationQuery("SELECT 1");
		          p.setTestOnReturn(false);
		          p.setValidationInterval(30000);
		          p.setTimeBetweenEvictionRunsMillis(30000);
		          p.setMaxActive(100);
		          p.setInitialSize(10);
		          p.setMaxWait(10000);
		          p.setRemoveAbandonedTimeout(60);
		          p.setMinEvictableIdleTimeMillis(30000);
		          p.setMinIdle(10);
		          p.setLogAbandoned(true);
		          p.setRemoveAbandoned(true);
		          p.setJdbcInterceptors(
		            "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
		            "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		          DataSource datasource = new DataSource();
		          datasource.setPoolProperties(p);

		          Connection con = null;
		          try {
		            con = datasource.getConnection();
		            Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery("select * from user");
		            int cnt = 1;
		            while (rs.next()) {
		                System.out.println((cnt++)+". Host:" +rs.getString("Host")+
		                  " User:"+rs.getString("User")+" Password:"+rs.getString("Password"));
		            }
		            rs.close();
		            st.close();
		          } finally {
		            if (con!=null) try {con.close();}catch (Exception ignore) {}
		          }
		      }

		  }
		  
		  
		  */
		  
				
	}

	@Bean
	@DependsOn("liquibaseBean")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		// hibernateJpaVendorAdapter.setShowSql(true);
		emf.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		emf.setPackagesToScan("org.scuola247.desktop.entity");

		Map<String, String> properties = Maps.newHashMap();
		properties.put("jadira.usertype.databaseZone", "UTC");
		properties.put("jadira.usertype.javaZone", "UTC");
		emf.setJpaPropertyMap(properties);

		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws NamingException {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	@Bean
	public SpringLiquibase liquibaseBean() throws NamingException {
		SpringLiquibase bean = new SpringLiquibase();
		bean.setDataSource(dataSource());
		bean.setChangeLog("classpath:db/changelog.xml");
		return bean;
	}

}
