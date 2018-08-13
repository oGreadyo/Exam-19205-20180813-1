<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="shortcut icon" href="/webshopping/img/logo1.png">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login_update.css">
<title>Login</title>
</head>

<%
	String islogin = request.getParameter("islogin");
	if ("1".equals(islogin)) {
		session.setAttribute("user", null);
	}
%>

<body>
	<!-- 代码 开始 -->
	<div class="wrapper">
		<div class="container">
			<h1>电影租赁系统</h1>

			<form name="loginForm"
				action="/Exam-19205-20180813-1/CustomerLoginServlet" method="get"
				class="test">
				<%
					if (request.getAttribute("return_uri") != null) {
				%>
				<input type="hidden" name="return_uri"
					value="<%=request.getAttribute("return_uri")%>">
				<%
					}
				%>



				<input name="userName" type="text" placeholder="用户名">
				<br> <br>
				 <input name="password" type="password" placeholder="密码"> <br>
				<br> <br>
				<button type="submit" id="login-button">登录</button>
				<br>
			</form>
			<!-- <form>
				<button type="submit" id="login-button" class="test">
					<a id="reg" href="register_update.html">注册</a>
				</button>
			</form> -->
		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>

	<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script>
		$('#login-button').click(function(event) {
			event.preventDefault();
			$('form').fadeOut(500);
			$('.wrapper').addClass('form-success');
		});
	</script>
	<!-- 代码 结束 -->

	<div class="tailer"
		style="text-align: center; font: normal 14px/24px 'MicroSoft YaHei'; color: #000000;">
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br>
		<p>©2018 zhouyu. All rights reserved.</p>
	</div>
</body>

</html>