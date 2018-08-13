package com.hand.filmmgt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hand.filmmgt.model.Film;
import com.hand.filmmgt.service.impl.FilmServiceImpl;
/**
 * Servlet implementation class DeleteFilmServlet
 */
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;

	private FilmServiceImpl filmService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		filmService = (FilmServiceImpl) applicationContext.getBean("filmServiceImpl");
	}

	public DeleteFilmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf8");// 防止中文乱码

		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();

		String String1 = (String) session.getAttribute("deleteId");
		Long deleteId = Long.parseLong(String1);
		String string2 = (String) request.getSession().getAttribute("deleteId");
		Long deleteId1 = Long.parseLong(string2);
		System.err.println("被删除的电影的id为：" + deleteId + "   No2: " + deleteId1);

		filmService.deleteById(deleteId);
		List<Film> listFilm = filmService.findAll();
		session.setAttribute("films", listFilm);
		pw.write("<script language='javascript'>alert('    删  除  成  功 :) ');window.location.href='Home.jsp';</script>");

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
