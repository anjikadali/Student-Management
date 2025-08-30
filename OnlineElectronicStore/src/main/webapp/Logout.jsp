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
session.invalidate();
out.println("Logout Succesfilly");
%>
</h1>
</center>
<jsp:include page="index.html"></jsp:include>
</body>
</html>