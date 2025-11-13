<%@ page import="pack1.CustomerBean" %>
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
CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
out.println("Welcome "+cbean.getC_fname()+"<br><br>");
%>
<a href="view2">View Product</a><br><br>
<a href="Logout">Logout</a><br><br>
</h1>
</center>
</body>
</html>