<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
<%@ page import="com.myapp.beans.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All Cars</h2>
<div align="right">
<form method="post" action="MainController">
<input type="hidden" name="page" value="search">
<input type="text" name="search" placeholder="Search Car Name">
<input type="submit" value="Search">
</form></div>
<hr>
<ul>
<%
List<Product> list =(List<Product>)request.getAttribute("list");
for(Product p : list){
%>
	<li> <a href="MainController?page=product&id=<%=p.getId()%>">
	<%=p.getName() %></a>	
	<%=p.getPrice()%>
</li>
<% 
	}
%>

</ul>
</body>
</html>