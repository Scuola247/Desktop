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

	@RequestMapping(value = "/institute_logo/{id}")
	public void getInstitutesLogo(HttpServletRequest request, HttpServletResponse response, Locale locale, @PathVariable long id) throws SQLException, IOException {

			response.setContentType(JPG_CONTENT_TYPE);
			byte[] output = ImageAccess.getInstitutesLogo(id);
			response.setContentLength(output.length);

			ServletOutputStream out = response.getOutputStream();
			out.write(output);
			out.flush();

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
