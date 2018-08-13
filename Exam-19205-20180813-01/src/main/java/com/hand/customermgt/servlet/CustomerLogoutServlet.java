package com.hand.customermgt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import com.hand.customermgt.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerLogoutServlet
 */
public class CustomerLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerLogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 存放在session里面
		HttpSession session = request.getSession();
		session.setAttribute("customer", null);
		session.setAttribute("flag", "login_error");
		System.err.println("用户退出成功！");
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
