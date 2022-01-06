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
	<table border="3">
	<tr>
		<th>Employ Number </th>
		<th>Employ Name </th>
		<th>Gender  </th>
		<th>Department </th>
		<th>Designation</th>
		<th>Basic</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
<%
	for(Employ employ : arrEmploy){
%>
	<tr>
		<td><%=employ.getEmpno() %></td>
		<td><%=employ.getName() %></td>
		<td><%=employ.getGender() %></td>
		<td><%=employ.getDept() %></td>
		<td><%=employ.getDesig() %></td>
		<td><%=employ.getBasic() %></td>
		<td><a href=UpdateEmploy.jsp?empno=<%=employ.getEmpno() %>>Update</a></td>
		<td><a href=DeleteEmploy.jsp?empno=<%=employ.getEmpno() %>>Delete</a></td>
	
	
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