package com.hand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter {

	public PermissionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.err.println("进入了过滤器---------");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf8");// 防止中文乱码

		PrintWriter pw = response.getWriter();

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String servletPath = req.getServletPath();// 获取请求中的path
		HttpSession session = req.getSession();// 获取session对象
		String flag = (String) session.getAttribute("flag");
		System.err.println("过滤器中flag的值：" + flag);
		System.err.println("过滤器中servletPath的值：" + servletPath);

		// if(servletPath !=null
		// &&(servletPath.equals("/Exam-19205-20180813-1/index.jsp")
		// ||servletPath.equals("/Exam-19205-20180813-1") )){
		if (servletPath != null && (servletPath.equals("/index.jsp")||servletPath.equals("/CustomerLoginServlet")
				)) {
			chain.doFilter(request, response);
		} else {
			if (flag != null && flag.equals("login_success")) {
				chain.doFilter(request, response);// 如果处于登录状态，直接可以进行访问
			} else if (flag != null && flag.equals("login_error")) {
				req.setAttribute("return_ui", servletPath);
				// RequestDispatcher requestDispatcher =
				// req.getRequestDispatcher("index.jsp");
				pw.write(
						"<script language='javascript'>alert('    请  先  登   录 :) ');window.location.href='index.jsp';</script>");
			} else {
				req.setAttribute("return_ui", servletPath);
				pw.write(
						"<script language='javascript'>alert('    请  先  登   录 :) ');window.location.href='index.jsp';</script>");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
