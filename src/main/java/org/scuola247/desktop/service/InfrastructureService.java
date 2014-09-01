package org.scuola247.desktop.service;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.POLL;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.joda.time.DateTime;
import org.scuola247.desktop.entity.AccessLog;
import org.scuola247.desktop.security.UtenteDettagli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
//import javax.persistence.EntityManager;

@Service
public class InfrastructureService {

//	@PersistenceContext
//	private EntityManager entityManager;

	@Autowired
	private MailService mailService;

	@Autowired
	private Environment environment;

	@ExtDirectMethod(value = POLL, event = "heartbeat")
	@PreAuthorize("isAuthenticated()")
	public void heartbeat() {
		// nothing here
	}

	@ExtDirectMethod
	@PreAuthorize("hasRole('Gestore')")
	@Transactional
	public boolean switchUser(Long userId) {
/*
		User switchToUser = entityManager.find(User.class, userId);
		if (switchToUser != null) {
			//Util.signin(switchToUser);
			return true;
		}
*/
		return false;
	}

	@ExtDirectMethod
	@PreAuthorize("isAuthenticated()")
	@Transactional
	public String getLoggedOnUser(HttpSession session, HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UtenteDettagli) {
			UtenteDettagli userDetail = (UtenteDettagli) principal;

			if (session != null) {
				AccessLog accessLog = new AccessLog();
				accessLog.setUserName(userDetail.getUsername());
				accessLog.setSessionId(session.getId());
				accessLog.setLogIn(DateTime.now());
				accessLog.setUserAgent(request.getHeader("User-Agent"));

//				entityManager.persist(accessLog);
			}

			return userDetail.getUsername();

		}
		return principal.toString();
	}

	@ExtDirectMethod
	@PreAuthorize("isAuthenticated()")
	@Transactional(readOnly = true)
	public UserSettings getUserSettings() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UtenteDettagli) {
			UtenteDettagli userDetail = (UtenteDettagli) principal;
			if (userDetail.getSettings() != null) {
				return userDetail.getSettings();
			}
		}
		return null;
	}

	@ExtDirectMethod
	@PreAuthorize("isAuthenticated()")
	@Transactional
	public void saveUserSettings(String wallpaper, Integer width, Integer height, String picturePos,
			String backgroundColor) throws IOException {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetail = (UserDetails) principal;
			UserSettings us = new UserSettings(wallpaper, width, height, picturePos, backgroundColor);
			
			//TODO: invocare update settings dell'utente
		}
	}

	private static String serializeUserSettings(UserSettings us) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(us);
			oos.flush();
			return DatatypeConverter.printBase64Binary(bos.toByteArray());
		}
	}

	private static UserSettings deserialUserSettings(String s) {

		if (s != null) {
			byte[] b = DatatypeConverter.parseBase64Binary(s);
			try (ByteArrayInputStream bis = new ByteArrayInputStream(b);
					ObjectInputStream ois = new ObjectInputStream(bis)) {
				return (UserSettings) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				// do nothing here
			}
		}

		return null;
	}

	@ExtDirectMethod
	@PreAuthorize("isAuthenticated()")
	public void sendFeedback(String feedbackText) throws MessagingException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			String to;
			if (environment.acceptsProfiles("development")) {
				to = "fol@fulcro.net";
			} else {
				to = "fol@fulcro.net";
			}
			mailService.sendHtmlMessage(username, to, "Feedback from desktop@scuola247.it", feedbackText);
		}
	}

}
