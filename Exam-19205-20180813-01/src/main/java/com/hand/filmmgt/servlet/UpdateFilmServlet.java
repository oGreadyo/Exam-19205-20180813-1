package com.hand.filmmgt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hand.filmmgt.model.Film;
import com.hand.filmmgt.model.Language;
import com.hand.filmmgt.service.impl.FilmServiceImpl;
import com.hand.filmmgt.service.impl.LanguageServiceImpl;

/**
 * Servlet implementation class UpdateFilmServlet
 */
public class UpdateFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;

	private FilmServiceImpl filmService;

	private LanguageServiceImpl languageService;

	public UpdateFilmServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		filmService = (FilmServiceImpl) applicationContext.getBean("filmServiceImpl");
		languageService = (LanguageServiceImpl) applicationContext.getBean("languageServiceImpl");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf8");// 防止中文乱码

		PrintWriter pw = response.getWriter();

		List<Language> languages = new ArrayList<Language>();
		languages = languageService.findAll();

		HttpSession session = request.getSession();
		String String1 = (String) session.getAttribute("deleteId");
		Long id = Long.parseLong(String1);

		Film film = filmService.findById(id);

		String title = request.getParameter("fileTitle");
		String description = request.getParameter("filmDescription");
		String language = request.getParameter("language");

		Language lang = null;
		for (Language l : languages) {
			if (l.getLanguage().equals(language)) {
				lang = l;
			}
		}

		System.err.println("title: " + title);
		System.err.println("description : " + description);

		film.setTitle(title);
		film.setDescription(description);
		if (lang != null)
			film.setLanguage(lang);

		filmService.update(film);

		List<Film> listFilm = filmService.findAll();
		session.setAttribute("films", listFilm);
		pw.write("<script language='javascript'>alert('    修  改  成  功 :) ');window.location.href='Home.jsp';</script>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public FilmServiceImpl getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmServiceImpl filmService) {
		this.filmService = filmService;
	}

	public LanguageServiceImpl getLanguageService() {
		return languageService;
	}

	public void setLanguageService(LanguageServiceImpl languageService) {
		this.languageService = languageService;
	}
}
