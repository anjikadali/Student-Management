<%@ page import="pack1.AdminBean" %>
<%@ page import="pack1.ProductBean" %>
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
/*AdminBean abean=(AdminBean)session.getAttribute("abean");
ProductBean pb=(ProductBean)request.getAttribute("pbean");
String data=(String)request.getAttribute("msg");
out.println("Hello "+abean.getA_fname()+"Product Deleted<br><br>");*/
AdminBean abean = (AdminBean) session.getAttribute("abean");
ProductBean pb = (ProductBean) request.getAttribute("pbean");
String data = (String) request.getAttribute("msg");

if (abean != null) {
    out.println("Hello " + abean.getA_fname() + "!<br><br>");
}

if (data != null) {
    out.println("<span style='color:green'>" + data + "</span><br><br>");
}

if (pb != null) {
%>
<form action="delete" method="post">
    <input type="hidden" name="pcode" value="<%= pb.getP_code() %>"><br><br>
    <input type="submit" value="Delete Product">
</form>
<%
}
%>
<a href="AddProduct.html">Add Product</a><br><br>
<a href="view1">View Product</a><br><br>
<a href="Logout">Logout</a><br><br>
</h1>

</body>
</html>