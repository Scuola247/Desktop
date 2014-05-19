package org.scuola247.desktop.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scuola247.desktop.logic.ImageAccess;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/images", method = RequestMethod.GET)
public class ImagesController implements InitializingBean {

	private static final String JPG_CONTENT_TYPE = "image/jpeg";
	private static final int CACHE_DURATION_IN_SECOND = 60 * 60 * 24; // 24 ore
	private static final long CACHE_DURATION_IN_MS = CACHE_DURATION_IN_SECOND  * 1000;

	private void setCache(HttpServletResponse response){
		long now = System.currentTimeMillis();
		((HttpServletResponse) response).addHeader("Cache-Control", "max-age=" + CACHE_DURATION_IN_SECOND);
		((HttpServletResponse) response).addHeader("Cache-Control", "must-revalidate");//optional
		((HttpServletResponse) response).setDateHeader("Last-Modified", now);
		((HttpServletResponse) response).setDateHeader("Expires", now + CACHE_DURATION_IN_MS);
	}
	
	@RequestMapping(value = "/institute_logo/{id}")
	public void getInstitutesLogo(HttpServletRequest request, HttpServletResponse response, Locale locale, @PathVariable long id) throws SQLException, IOException {
		setCache(response);
		response.setContentType(JPG_CONTENT_TYPE);
		byte[] output = ImageAccess.getInstitutesLogo(id);
		response.setContentLength(output.length);

		ServletOutputStream out = response.getOutputStream();
		out.write(output);
		out.flush();

	}

	@RequestMapping(value = "/person/{id}")
	public void getPersona(HttpServletRequest request, HttpServletResponse response, Locale locale, @PathVariable long id) throws SQLException, IOException {
		setCache(response);
		response.setContentType(JPG_CONTENT_TYPE);
		byte[] output = ImageAccess.getPersona(id);
		response.setContentLength(output.length);

		ServletOutputStream out = response.getOutputStream();
		out.write(output);
		out.flush();

	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
