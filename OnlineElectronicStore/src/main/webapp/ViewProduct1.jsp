<%@ page import="pack1.ProductBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pack1.AdminBean" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="pack1.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Products</title>
<style>
    table { border-collapse: collapse; width: 80%; margin: 20px auto; }
    th, td { padding: 10px; border: 1px solid #333; text-align: center; }
    th { background-color: #f2f2f2; }
    h2 { text-align: center; }
</style>
</head>
<body>
<%
AdminBean abean = (AdminBean) session.getAttribute("abean");
CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productlist");
%>

<h2>
<%
if (abean != null) {
out.println("Hello " + abean.getA_fname() + ", these are your Product details");
} else if (cbean != null) {
out.println("Hello " + cbean.getC_fname() + ", here are the available products");
} else {
out.println("Product List");
}
%>
</h2>

<%
if (al == null || al.isEmpty()) {
%>
    <h3 style="text-align:center;color:red;">Products are NOT available</h3>
<%
} else {
%>
    <table>
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Company</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Buy</th>
        </tr>
<%
Iterator<ProductBean> i = al.iterator();
while (i.hasNext()) {
ProductBean pb = i.next();
%>
        <tr>
            <td><%= pb.getP_code() %></td>
            <td><%= pb.getP_name() %></td>
            <td><%= pb.getP_comp() %></td>
            <td><%= pb.getP_price() %></td>
            <td><%= pb.getP_qnty() %></td>
            <td>
                <form action="buy" method="post">
                    <input type="hidden" name="pcode" value="<%= pb.getP_code() %>" />
                    <input type="number" name="reqQty" min="1" max="<%= pb.getP_qnty() %>" required />
                    <input type="submit" value="Buy" />
                </form>
            </td>
        </tr>
<%
}
%>
</table>
<%
}
%>
</body>
</html>