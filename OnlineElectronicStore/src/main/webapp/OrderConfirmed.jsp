<%@ page import="pack1.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Order Confirmed</title>
</head>
<body style="text-align: center; padding-top: 50px;">

<%	
	//CustomerBean cbean = (CustomerBean)session.getAttribute("cbean");
    String pcode = (String) request.getAttribute("pcode");
    String qty = String.valueOf(request.getAttribute("reqQty"));
    int price = (int) request.getAttribute("price");
    int total = (int) request.getAttribute("total");
    //out.println("Hello "+cbean.getC_fname());
%>

<p><b>Its Your Product Code:</b> <%= pcode %></p>
<p><b>Ordered of Items:</b> <%= qty %></p>
<p><b>One Product price:</b> ₹<%= price %></p>
<p><b>You Have Charged:</b> ₹<%= total %></p>
<h1 style="color: green;"> Your Order is Places Successfully!!!</h1>
<p>Thank you for shopping with us!</p>

<a href="ViewProduct.jsp">Back to Products</a>
<a href="Logout">Logout</a>

</body>
</html>