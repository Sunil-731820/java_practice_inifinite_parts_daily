<%@page import="com.java.hib.EmployDAO"%>
<%@page import="com.java.hib.Employ"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border="10px solid black" bordercolor="red" align="center">
	<form method="get" action="EmploySearch.jsp">
		Employ Number :
			<input type="number" name="empno"><br><br>
			<input type="submit" value="search"><br><br>
	</form>
	<%
	if (request.getParameter("empno") !=null) {
		int empno = Integer.parseInt(request.getParameter("empno"));
		Employ employ = new EmployDAO().searchEmploy(empno);
		if(employ!=null){
			out.println("Employ Name " + employ.getName()+"<br><br>");
			out.println("Gender is " + employ.getGender()+"<br><br>");
			out.println("Department is " + employ.getDept()+"<br><br>");
			out.println("Designation is " + employ.getDesig()+"<br><br>");
			out.println("Basic is " + employ.getBasic()+"<br><br>");
		}else{
			out.println("Records Not Found ");
		}
			
		}
	
	%>
	
</table>
</body>
</html>