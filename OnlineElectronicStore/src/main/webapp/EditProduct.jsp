<%@ page import="pack1.ProductBean"%>
<%@ page import="pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><center>
<h1>
<%
AdminBean abean=(AdminBean)session.getAttribute("abean");
ProductBean pb=(ProductBean)request.getAttribute("pbean");
out.println("Hello "+abean.getA_fname()+" please edit!!!<br><br>");
%>
<form action="update" method="post">
Product Price <input type="text" name=pprice value="<%=pb.getP_price() %>"><br><br>
Product Quantity <input type="text" name=pqty value="<%=pb.getP_qnty() %>"><br><br>
<input type="hidden" name =pcode value="<%=pb.getP_code() %>"><br><br>
<input type="submit" value="Update">
</form>
</h1>
</center>

</body>
</html>