<%@page import="com.java.dashborad.EmployDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String firstName =request.getParameter("firstName");
	EmployDAO dao = new EmployDAO();
	dao.deleteEmploy(firstName);
%>
<jsp:forward page="EmployTable.jsp"></jsp:forward>
</body>
</html>