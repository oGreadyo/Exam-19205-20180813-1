<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ page import="com.hand.filmmgt.model.Language"%>
<%@ page import="com.hand.filmmgt.model.Film"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" type="text/css" href="css/Register.css">
<link rel="shortcut icon" href="/webshopping/img/logo1.png">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/personcenter.css" />
<link rel="stylesheet" type="text/css" href="css/FilmDetail.css" />
<script type="text/javascript"
	src="js/copy.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String path = request.getParameter("path");
		String id = request.getParameter("id");
		Long filmId = Long.parseLong(id);
		String title = request.getParameter("title");
		Film film = null;
		String language = "没有语言";
		List<Film> films = new ArrayList<Film>();
		films = (List) request.getSession().getAttribute("films");
		for(Film f:films){
			if(filmId.equals(f.getId())){
				if(f.getLanguage()!=null){
					language = f.getLanguage().getLanguage();
				}
				break;
			}
		}
		String description = request.getParameter("description");

		List<Language> langs = (List) request.getSession().getAttribute("langs");

		session.setAttribute("deleteId", "" + id);
	%>
	<div id="container">
		<div id="top">
			<a href="Home.jsp"><label id="mainpage">返回</label></a>
		</div>
		<div id="mid">
			<div id="Paypage">
				<div id="buyimg">
					<img src="img2/<%=path%>" height="400px" width="300px" id="goodimg" />
				</div>
				<div id="buyopertate">
					<div id="topbutton">
						<br /> <br /> <br />

						<form action="/Exam-19205-20180813-1/UpdateFilmServlet">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">ID：</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="inputEmail3"
										readonly="readonly" value="<%=id%>">
								</div>
							</div>

							<br /> <br /> <br />
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">影名：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="电影名" value="<%=title%>" name="fileTitle">
								</div>
							</div>

							<br /> <br /> <br />
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">介绍：</label>
								<div class="col-sm-10">
									<textarea name="filmDescription" clos="200"  rows="5" warp="virtual" placeholder="内容介绍"
									style="resize:none;width:360px;"><%=description%></textarea>
								</div>
							</div>
							
							<br /> <br /> <br />
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">语言：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputPassword3"
										name="filmDescription" placeholder="语言" readonly="readonly"
										value="<%=language%>">
								</div>
							</div>

							<select name="language" title="点击选择语言">
								<option value="English">English</option>
								<option value="Japanese">Japanese</option>
								<option value="Chinese">Chinese</option>
								<option value="Russian">Russian</option>
							</select> 
							
							 <input type="submit" value="修改"
								id="bottumbuttonone" style="margin-left: 220px" class="bottumbt"></input>
						</form>
					</div>


					<br /> <br /><br/><br/><br/>
					<div id="bottumbutton">
						<form action="/Exam-19205-20180813-1/DeleteFilmServlet">
							<input type="submit" value="删除" id="bottumbuttonone"
								class="bottumbt"></input>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>