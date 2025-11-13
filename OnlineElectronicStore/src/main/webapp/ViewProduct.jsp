<%@page import="com.sun.net.httpserver.Request"%>
<%@ page import="pack1.ProductBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pack1.AdminBean" %>
<%@ page import="java.util.Iterator" %>
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
ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("productlist");
out.println("<u>Hello "+abean.getA_fname()+" these are your Product details</u><br><br>");

if(al.size()==0){
	out.println("Product are NOT available");
	}
else{
	Iterator<ProductBean> i=al.iterator();
	while(i.hasNext()){
		ProductBean pb=i.next();
		out.println(pb.getP_code()+" "+pb.getP_name()+" "+pb.getP_comp()+" "+pb.getP_price()+" "+pb.getP_qnty()
		
				+"<a href='edit?pcode="+pb.getP_code()+"'>Edit</a>"+" "
				+"<a href='delete?pcode="+pb.getP_code()+"'> Delete</a>"+"<br><br>");
		
	}
}
%>
</h1>
</body>
</html>