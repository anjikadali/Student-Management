<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Buy Product Result</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    String pcode = (String) request.getAttribute("pcode");
    String reqQty = (String) request.getAttribute("reqQty");
%>

<% if (msg == null) { %>
    <h2>Order Placed Successfully!</h2>
    <p>Product Code: <%= pcode %></p>
    <p>Quantity Ordered: <%= reqQty %></p>
<% } else { %>
    <h2 style="color:red;"><%= msg %></h2>
<% } %>

<br>
<a href="ViewProduct.jsp">Back to Products</a>
<a href="Logout">Logout</a>
</body>
</html>