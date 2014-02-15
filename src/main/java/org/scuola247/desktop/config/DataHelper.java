package org.scuola247.desktop.config;


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DataHelper {

	public static DataSource myDataSource()  {

		DataSource ds = null;
		PoolProperties pool = null;

        ds= new DataSource();
		pool = new PoolProperties();
        
		pool.setUrl("jdbc:postgresql://localhost/desktop");
        pool.setDriverClassName("org.postgresql.Driver");
        pool.setUsername("postgres");
        pool.setPassword("postgres");
        pool.setJmxEnabled(true);
        pool.setTestWhileIdle(false);
        pool.setTestOnBorrow(true);
        pool.setValidationQuery("SELECT 1");
        pool.setTestOnReturn(false);
        pool.setValidationInterval(30000);
        pool.setTimeBetweenEvictionRunsMillis(30000);
        pool.setMaxActive(100);
        pool.setInitialSize(10);
        pool.setMaxWait(10000);
        pool.setRemoveAbandonedTimeout(60);
        pool.setMinEvictableIdleTimeMillis(30000);
        pool.setMinIdle(10);
        pool.setLogAbandoned(true);
        pool.setRemoveAbandoned(true);
        pool.setJdbcInterceptors(
        		"org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
        		"org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
       
        
        ds.setPoolProperties(pool);

        return ds;
	}

	public static Connection myConnection () throws SQLException  {
		
		Connection conn = null;
        
		conn = myDataSource().getConnection();
		conn.setAutoCommit(false);
		
		return conn;
	}

}
