<%@page import="com.java.hib.EmployDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="deleteEmploy.jsp" method="get">
	Employ Number :
	<input type="text" name="empno"><br><br>
	<input type="submit" value="delete">
</form>

<%
	if(request.getParameter("empno")!=null){
		int empno = Integer.parseInt(request.getParameter("empno"));
		out.println(new EmployDAO().deleteEmploy(empno));
		
	}

%>

</body>
</html>