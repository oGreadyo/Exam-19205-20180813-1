
<%@page import="com.hand.filmmgt.model.Film"%>
<%@page import="java.util.*"%>
<%@ page import="com.hand.customermgt.customer.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/webshopping/img/logo1.png">
<title>电影租赁系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/Home.css" />

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/Home.js" defer="defer"></script>
<script type="text/javascript" src="js/copy.js"></script>
</head>
<body>
	<%
		Customer customer = (Customer) session.getAttribute("customer");

		String Login = "登录";
		String Register = "注册";
		String personcenter = "";
		String myhref = "";
		//String label = "Register.jsp";
		String label = "register_update.html";
		String mylabel = "";
		String islogin = "0";
		if (customer != null) {
			Login = "退出";
			label = "";
			islogin = "1";//已经登录
			Register = customer.getName();
		} else {
			islogin = "0";
		}
	%>
	<div id="container">
		<div id="topone">

			<%-- <form action="/Exam-19205-20180813-1/CustomerLogoutServlet">
				<a href="index.jsp?islogin=<%=islogin%>"><label class="toplabel"
				id="Loginlabel"><%=Login%></label></a>
			</form> --%>
			<a href="/Exam-19205-20180813-1/CustomerLogoutServlet" ><label class="toplabel"
				id="Loginlabel"><%=Login%></label></a> 
				<a href=<%=label%>><label
				class="toplabel"><%=Register%></label></a> <a href=<%=myhref%>><label
				class="toplabel"><%=personcenter%></label></a>

		</div>
		<div id="toptwo">
			<div id="logo">
				<label id="logoname">租赁网</label>
			</div>

			<form action="/Exam-19205-20180813-1/SearchFilmServlet" method="get">
				<div id="search">
					<input id="seinput" name="keyword" placeholder="电影名\电影ID 搜索电影" />
					<button id="searchbt" type="submit" title="不输入时点击按钮显示所有电影">搜索</button>

					<button id="searchbt" type="button" style="width: 130px">
						<a href="AddFilm.jsp" style="color: white; text-decoration: none">添加电影</a>
					</button>
				</div>
			</form>
		</div>


	</div>
	<div id="myCarousel" class="carousel slide"
		style="text-align: center; width: 1200px; float: left; margin-left: 5%; margin-right: 5%; margin-bottom: 3%">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators"
			style="margin-top: 100px; margin-right: 10%">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner" style="text-align: center; width: 1200px;">
			<div class="item active">
				<img src="img/1.png"
					style="height: 400px; width: 1200px; text-align: center;"
					alt="第一张图片">
			</div>
			<div class="item">
				<img src="img/2.png"
					style="height: 400px; width: 1200px; text-align: center;"
					alt="第二张图片">
			</div>
			<div class="item">
				<img src="img/3.png"
					style="height: 400px; width: 1200px; text-align: center;"
					alt="第三张图片">
			</div>
			<div class="item">
				<img src="img/4.png"
					style="height: 400px; width: 1200px; text-align: center;"
					alt="第四张图片">
			</div>
			<div class="item">
				<img src="img/5.png"
					style="height: 400px; width: 1200px; text-align: center;"
					alt="第五张图片">
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev" style="outline: none"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true" style=""></span>
			<span class="sr-only"> </span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next" style="outline: none"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only"> </span>
		</a>
	</div>
	</a>



	<!-- 		<div id="shoprecom">商品推荐</div> -->
	<br>
	<div id="shopimg">

		<%
			List<Film> films = new ArrayList<Film>();
			films = (List) request.getSession().getAttribute("films");
			List<Film> filmToView = new ArrayList<Film>();
			//out.println(goods.size());
			/* for (Film f : films) {
				if (g.getIsOnSale())
					goosToView.add(g);
			} */
			//out.println("上架的商品 ： " +goosToView.size());
		%>
		<div id="two" class="center-right-two">
			<table style="margin: auto; text-align: center">
				<tr>
					<%
						int n = 0;
						int i = 0;
					%>
					<c:forEach var="film" items='<%=films%>'>
						<%
							n++;
						%>
						<td width="20%">
							<%
								String ur = films.get(5 * i + n - 1).getPicPath();
							%> <a
							href="FilmDetail.jsp?path=<%=ur%>&title=<%=films.get(5 * i + n - 1).getTitle()%>&id=<%=films.get(5 * i + n - 1).getId()%>&description=<%=films.get(5 * i + n - 1).getDescription()%>">
								<img src="img2/<%=ur%>" style="width: 200px; height: 250px"
								title="点击查看详情" />
						</a> <br> <h style="color: blue; font-size: 16px;">${ film.title}</h>
							<br /> <h>${film.id}</h> <br /> <%--  <% if(films.get(5 * i + n - 1).getLanguage()==null && i !=0 && n!=0) 
								 { %>
									 <hstyle="color: blue;">no language</h>
								 <% 
								 } else if(i !=0 && n!=0){
								 %>
								  <h>${films.get(5 * i + n -1).getLanguage().getLanguage() }</h>
								<%} %> --%>
							<p>
								<a
									href="FilmDetail.jsp?path=<%=ur%>&id=<%=films.get(5 * i + n - 1).getId()%>
									&title=<%=films.get(5 * i + n - 1).getTitle()%>
									&description=<%=films.get(5 * i + n - 1).getDescription()%>"
									style="color: red;">查看</a>
							</p> </span>
						</td>

						<%
							if (n >= 5) {
									i++;
									out.println("</tr><tr>");
									n = 0;
								}
						%>
					</c:forEach>
				</tr>
			</table>
		</div>

	</div>
	<div id="buttom">
		2018@yu.zhou hand.com 版权所有 | <a href="" style="color: white;">关于我们--(其实是都没有)</a>
	</div>
	<div id="buttom">随便你侵权，有钱打官司算我输</div>

	</div>
</body>
</html>