<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.myapp.beans.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Car Details...</h3>
<%
Product product =(Product)request.getAttribute("product");
%>
Name of the Car: <%=product.getName() %><br>
<%=product.getPrice() %> /- INR <br>
<%=product.getDescription() %><br>
</body>
</html>