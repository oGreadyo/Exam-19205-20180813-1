package com.hand.customermgt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hand.common.Md5;
import com.hand.customermgt.customer.Customer;
import com.hand.customermgt.service.CustomerService;
import com.hand.customermgt.service.impl.CustomerServiceImpl;
import com.hand.filmmgt.model.Film;
import com.hand.filmmgt.model.Language;
import com.hand.filmmgt.service.impl.FilmServiceImpl;
import com.hand.filmmgt.service.impl.LanguageServiceImpl;

/**
 * Servlet implementation class CustomerLoginServlet
 */
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerServiceImpl customerService;

	private ApplicationContext applicationContext;

	private LanguageServiceImpl languageService;

	private FilmServiceImpl filmService;

	public CustomerLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf8");// 防止中文乱码

		PrintWriter pw = response.getWriter();

		String name = (String) request.getParameter("userName");
		String pswd = (String) request.getParameter("password");

		String returnUri = request.getParameter("return_uri");
		System.err.println("登录的servlet中 uri的值："+returnUri);
		
		// 存放在session里面
		HttpSession session = request.getSession();

		List<Customer> listCust = customerService.findAll();
		List<Language> languages = languageService.findAll();
		session.setAttribute("langs", languages);

		Customer customer = new Customer();
		boolean flag = false;// false 表示登录失败
		for (Customer c : listCust) {
			if (c.getName() != null && c.getPassword() != null && c.getName().equals(name)
					&& Md5.checkPassword(pswd, c.getPassword())) {
				customer = c;
				flag = true;
				break;
			}
		}

		if (flag)// 登录成功
		{
			session.setAttribute("customer", customer);
			List<Film> listFilm = filmService.findAll();
			session.setAttribute("films", listFilm);
			session.setAttribute("flag", "login_success");
			pw.write(
					"<script language='javascript'>alert('    登   录   成   功  :)');window.location.href='Home.jsp';</script>");
		} else {// 登录失败
			session.setAttribute("flag", "login_error");
			pw.write("<script language='javascript'>alert('用户名或密码错误!');window.location.href='index.jsp';</script>");
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		filmService = (FilmServiceImpl) applicationContext.getBean("filmServiceImpl");
		customerService = (CustomerServiceImpl) applicationContext.getBean("customerServiceImpl");
		languageService = (LanguageServiceImpl) applicationContext.getBean("languageServiceImpl");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
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
