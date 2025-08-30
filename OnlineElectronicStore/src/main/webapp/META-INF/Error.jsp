<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<%
	String data=(String)request.getAttribute("msg");
	//response.sendError(HttpServletResponse.SC.NOT_FOUND, data);
%>
<%= data%><br><br>

<a href="AddProduct.html">Add Product</a>
<a href="view1">View Product</a>
<a href="Logout">Logout</a>
</h1>
</center>
</body>
</html>