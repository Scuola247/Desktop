package org.scuola247.desktop.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.scuola247.desktop.config.DataHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/print", method = RequestMethod.GET)
public class PrintController implements InitializingBean {

	private static final String PDF_CONTENT_TYPE = "application/pdf";

	@RequestMapping(value = "/institute/{desc}")
	public void getInstitute(HttpServletRequest request, HttpServletResponse response, Locale locale, @PathVariable String desc) throws IOException, JRException, SQLException {
		Connection conn = null;
		
		try{
			conn = DataHelper.myConnection();
			String reportPath = "/istituti.jasper";
			
			InputStream reportInputStream = this.getClass().getResourceAsStream(reportPath);
			
			HashMap<String, Object> hm = new HashMap<>();
			
			hm.put("descrizione", desc);
			
			response.setContentType(PDF_CONTENT_TYPE);
			JasperPrint print = JasperFillManager.fillReport(reportInputStream, hm, conn);
			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			
			OutputStream out = response.getOutputStream();
			
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
			exporter.exportReport();
			
			out.flush();
		}
		catch (JRException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
		catch (SQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
		catch (Exception e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@RequestMapping(value = "/registroDiClasse/{istituto}/{anno_scolastico}/{classe}")
	public void getRegistroDiClasse(HttpServletRequest request, HttpServletResponse response, Locale locale, @PathVariable long istituto, @PathVariable long anno_scolastico, @PathVariable long classe) throws IOException, JRException, SQLException {
		Connection conn = null;
		
		try{
			conn = DataHelper.myConnection();
			String reportFolderPath = this.getClass().getResource("/jasper/").getPath();
			String reportPath = "/jasper/registro_di_classe.jasper";

			String profile = request.getServletContext().getInitParameter("environment");
			
			InputStream reportInputStream = this.getClass().getResourceAsStream(reportPath);
			
			HashMap<String, Object> hm = new HashMap<>();
			hm.put("istituto", istituto);
			hm.put("anno_scolastico", anno_scolastico);
			hm.put("classe", classe);
			hm.put("environment", profile);
			hm.put("report_path", reportFolderPath);
			
			response.setContentType(PDF_CONTENT_TYPE);
		
			JasperPrint print = JasperFillManager.fillReport(reportInputStream, hm, conn);
			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			
			OutputStream out = response.getOutputStream();
			
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
			exporter.exportReport();
			
			out.flush();
		}
		catch (JRException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
		catch (SQLException e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
		catch (Exception e){
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
