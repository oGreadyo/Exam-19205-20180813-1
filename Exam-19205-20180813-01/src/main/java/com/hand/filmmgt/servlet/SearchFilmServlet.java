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
 * Servlet implementation class SearchFilmServlet
 */
public class SearchFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;

	private FilmServiceImpl filmService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		filmService = (FilmServiceImpl) applicationContext.getBean("filmServiceImpl");
	}

	public SearchFilmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf8");// 防止中文乱码

		PrintWriter pw = response.getWriter();

		List<Language> languages = new ArrayList<Language>();

		HttpSession session = request.getSession();

		String keyword = request.getParameter("keyword");

		List<Film> films = filmService.findAll();
		if (keyword.trim() == "") {
			session.setAttribute("films", films);
		} else {
			List<Film> filmsNew = new ArrayList<Film>();
			for (Film film : films) {
				if (film.getTitle().contains(keyword) || film.getId().toString().contains(keyword)) {
					filmsNew.add(film);
				}
			}
			session.setAttribute("films", filmsNew);
		}
		response.sendRedirect("Home.jsp");
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
}
