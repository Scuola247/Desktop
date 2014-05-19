package org.scuola247.desktop.web;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.PSQLException;
import org.scuola247.desktop.config.DataHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.bytecode.opencsv.CSVWriter;

@Controller
@RequestMapping(value="/export", method = RequestMethod.GET)
public class DataexportController {
	
	private static final String CSV_CONTENT_TYPE = "text/csv";
	
	@Autowired
	private MessageSource messageSource;
	
    @RequestMapping(value = "/FN1/{classe}.csv", method = RequestMethod.POST)
	@PreAuthorize("hasRole('Pubblico')")
    public void FN1(HttpServletRequest request, HttpServletResponse response, Locale locale, @PathVariable long classe) throws NoSuchMessageException, Exception {
    	
    	response.setContentType(CSV_CONTENT_TYPE);
    	Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		
		conn = DataHelper.myConnection();
		conn.setAutoCommit(false);
		// crea prepared statement

		if (!"".equals(classe)){
			stmt = conn.prepareCall("{ ? = call classi_alunni_indirizzi_ex_by_classe(?) }");
			// compila prepare statement
			stmt.registerOutParameter(1, Types.OTHER);
	
			stmt.setLong(2, classe);
			
			try{
				stmt.execute();
				
				rs = (ResultSet)stmt.getObject(1);
				
				OutputStream out = response.getOutputStream();
				CSVWriter writer = new CSVWriter(new PrintWriter(out), ';');
				writer.writeAll(rs, true);
				writer.close();
				out.flush();
				
			}
			catch (PSQLException e){
				Logger logger = LoggerFactory.getLogger(getClass());
				logger.error(e.getMessage(), e);
				//			throw e;
				throw e;
			}
			catch (Exception e){
				Logger logger = LoggerFactory.getLogger(getClass());
				logger.error(e.getMessage(), e);
				throw e;
			}
			finally{
				if (rs != null){
					rs.close();
				}
				if (stmt != null){
					stmt.close();
				}
				if (conn != null){
					conn.close();
				}
			}
		}
		else{
			//manca la classe
			throw new Exception(messageSource.getMessage("dataexport_missing_class", null, locale));
		}
    }
}
