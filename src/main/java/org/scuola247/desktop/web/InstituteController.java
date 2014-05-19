package org.scuola247.desktop.web;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.PSQLException;
import org.scuola247.desktop.config.DataHelper;
import org.scuola247.desktop.logic.ImageAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectResponseBuilder;

@Controller
public class InstituteController {
	
	@ExtDirectMethod(value = ExtDirectMethodType.FORM_POST)
    @RequestMapping(value = "/createNewInstitute", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('Docente','Dirigente','Gestore')")
	@Transactional(readOnly = true)
    public void createNewInstitute(final Locale locale, final HttpServletRequest request,
    				@RequestParam(value = "rv", required = false) final String rv,  
    				@RequestParam(value = "istituto", required = false) final String istituto, 
                    @RequestParam("descrizione") final String descrizione,
                    @RequestParam("codice_meccanografico") final String codice_meccanografico,
                    @RequestParam("mnemonico") final String mnemonico,
                    @RequestParam(value = "esempio", required = false, defaultValue = "false") final boolean esempio,
                    final HttpServletResponse response)
                    throws IOException, SQLException {
		String errorMessage = null;
		Connection conn = null;
		CallableStatement isrt = null;
		
		
		Long newRv = null;
		Long newInstituteCode = null;

		conn = DataHelper.myConnection();
		// crea prepared statement
		/*
		isrt = conn.prepareCall("{ ? = call istituti_ins(?,?,?,?) }");

		isrt.registerOutParameter(1,Types.BIGINT);

		isrt.setString(2, instituteDescription);
		isrt.setString(3, instituteCode);
		isrt.setString(4, institutesMnem);
		isrt.setBoolean(5, institutesExample);
		 */

		if ("".equals(rv)){
			isrt = conn.prepareCall("{call istituti_ins(?,?,?,?,?,?) }");
	
			isrt.registerOutParameter(1,Types.BIGINT);
			isrt.registerOutParameter(2,Types.BIGINT);
	
			isrt.setString(3, descrizione);
			isrt.setString(4, codice_meccanografico);
			isrt.setString(5, mnemonico);
			isrt.setBoolean(6, esempio);
			
			try{
				isrt.execute();
	
				newRv = isrt.getLong(1);
				newInstituteCode = isrt.getLong(2);
			}
			catch (PSQLException e){
				Logger logger = LoggerFactory.getLogger(getClass());
				logger.error(e.getMessage(), e);
				//			throw e;
				errorMessage = e.getMessage();
			}
			finally{
				if (isrt != null){
					isrt.close();
				}
				if (conn != null){
					conn.close();
				}
			}
		}
		else{
			//update
		    CallableStatement upd = null;

		    conn = DataHelper.myConnection();
			// crea prepared statement
			upd = conn.prepareCall("{ ? = call istituti_upd(?,?,?,?,?,?) }");

			upd.registerOutParameter(1,Types.BIGINT);
			
			long lIstituto = Long.parseLong(istituto);
			
			upd.setLong(2, Long.parseLong(rv));
			upd.setLong(3, lIstituto);
			upd.setString(4, descrizione);
			upd.setString(5, codice_meccanografico);
			upd.setString(6, mnemonico);
			upd.setBoolean(7, esempio);

			try{
				upd.execute();
							
				if (upd.getUpdateCount() > 0){
					// ha aggiornato qualcosa
				}
				newRv = upd.getLong(1);
				newInstituteCode = lIstituto;
			}
			catch (PSQLException e){
				Logger logger = LoggerFactory.getLogger(getClass());
				logger.error(e.getMessage(), e);
//				throw e;
				errorMessage = e.getMessage();
			}
			finally{
				if (upd != null){
					upd.close();
				}
				if (conn != null){
					conn.close();
				}
			}
		}
		
        ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request, response);

        if (newInstituteCode != null) {
	        builder.successful();
	        builder.addResultProperty("rv", newRv);
	        builder.addResultProperty("instituteId", String.valueOf(newInstituteCode));
        }
        else{
        	builder.unsuccessful();
        	builder.addResultProperty("errorMessage", errorMessage);
        }
        builder.buildAndWrite();
    }


	@ExtDirectMethod(value = ExtDirectMethodType.FORM_POST)
    @RequestMapping(value = "/uploadInstituteImage", method = RequestMethod.POST)
	@PreAuthorize("hasRole('Gestore')")
	@Transactional(readOnly = true)
    public void uploadInstituteImage(final Locale locale, final HttpServletRequest request,
                    @RequestParam("instituteLogo") final MultipartFile instituteLogo,
                    @RequestParam("rv") final String rv,
                    @RequestParam("instituteId") final String instituteId, 
                    final HttpServletResponse response)
                    throws IOException {
			String errorMessage = null;
			long newRv = -1;
            ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request, response);

            if (instituteLogo != null && !instituteLogo.isEmpty()) {
            	
            	
				try {
					newRv = ImageAccess.updateInstitutesLogo(Long.parseLong(rv), Long.parseLong(instituteId), instituteLogo.getBytes());
				} catch (NumberFormatException | SQLException e) {
					Logger logger = LoggerFactory.getLogger(getClass());
					logger.error(e.getMessage(), e);
					//			throw e;
					errorMessage = e.getMessage();
				}
	            if (newRv != -1) {
	            	builder.successful();
	            	builder.addResultProperty("rv", newRv);
	            }
	            else{
	            	builder.unsuccessful();
	            	builder.addResultProperty("errorMessage", errorMessage);
	            }
            }
            else{
            	builder.successful();
            	builder.addResultProperty("rv", rv);
            }
            
            builder.buildAndWrite();
    }

}
