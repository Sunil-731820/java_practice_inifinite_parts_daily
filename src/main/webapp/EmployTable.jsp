<%@page import="com.java.dashborad.Employ"%>
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
		EmployDAO dao = new EmployDAO();
	Employ[] arrEmploy = dao.showEmploy();
	
	%>
	<table border="3" align="center">
	<tr>
		<th>Employ First Name </th>
		<th>Employ Last Name </th>
		<th>Employ age  </th>
		<th>Employ Locations  </th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
<%
	for(Employ employ : arrEmploy){
%>
	<tr>
		<td><%=employ.getFirstName() %></td>
		<td><%=employ.getLastName() %></td>
		<td><%=employ.getAge() %></td>
		<td><%=employ.getLocation() %></td>
		<td><a href=UpdateEmploy.jsp?firstName=<%=employ.getFirstName()%>>Update</a></td>
		<td><a href=DeleteEmploy.jsp?firstName=<%=employ.getFirstName() %>>Delete</a></td>
	
	
	</tr>
<% 
} 
%>
	</table>
	<br><br>
	<hr>
	<a href="AddEmploy.jsp"> Add Employ </a>
	
</body>
</html>