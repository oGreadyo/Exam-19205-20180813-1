<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Register.css" />
<link rel="stylesheet" type="text/css" href="css/personcenter.css" />
<link rel="stylesheet" type="text/css" href="css/Buygoods.css" />
<script type="text/javascript"
	src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="js/Buygoods.js"></script>
</head>
<body>
	<%
		String path = request.getParameter("path");
		String price = request.getParameter("price");
		String id = request.getParameter("goodsid");
		String goodname=request.getParameter("goodsname");
		session.setAttribute("goodsid", "" + id);
	%>
	<div id="container">
		<div id="top">
			<a href="Home.jsp"><label id="mainpage">主页</label></a>
		</div>
		<div id="mid">
			<div id="Paypage">
				<div id="buyimg">
					<img src="http://localhost:8080/webshopping/images/<%=path%>"
						height="400px" width="300px" id="goodimg" />
				</div>
				<div id="buyopertate">
					<div id="topbutton">

						<p class="mygoods"><%=goodname %></p>
						<form action="/webshopping/BuyGoods">
							<input id="price" name="goodsprice" value="<%=price%>"
								readonly="readonly"></input>
					</div>
					<div id="bottumbutton">
						<input type="submit" value="购买" id="bottumbuttonone"
							class="bottumbt"></input>
						</form>
						<a href="Home.jsp"><button id="bottumbuttontwo"
								class="bottumbt">再想想</button></a>
					</div>

				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>