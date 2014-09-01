package org.scuola247.desktop.config;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.scuola247.desktop.security.UtenteDettagli;
import org.springframework.security.core.context.SecurityContextHolder;

public class DataHelper {

	public static DataSource myDataSource(String username, String password) throws SQLException {
		
		InitialContext cxt;
		DataSource ds = null;
		try {
			cxt = new InitialContext();
		
			ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/scuola247" );
		} catch (NamingException e) {
			throw new SQLException(e);
		}
		return ds;
	}
	
//	
//	public static PGPoolingDataSource myDataSource(String username, String passwrod) throws SQLException  {
//	
//		PGPoolingDataSource ds = null;
//		try {
//			ds = (PGPoolingDataSource)new InitialContext().lookup("scuola247ds");
//			
////			ds = (PGPoolingDataSource)new InitialContext().lookup("java:comp/env/jdbc/scuola247ds");
//			
//		} catch (NamingException e) {
//			throw new SQLException("Datasource problem", e);
//		}
//		
//        return ds;
//	}

	public static Connection myConnection () throws SQLException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UtenteDettagli userDetail = (UtenteDettagli) principal;
		return myConnection(userDetail.getUsername(), userDetail.getPassword());
	}
	
	public static Connection myConnection (String username, String password) throws SQLException  {
		
		Connection conn = null;
        
		conn = myDataSource(username, password).getConnection(username, password);
		conn.setAutoCommit(true);
		
		return conn;
	}

}
