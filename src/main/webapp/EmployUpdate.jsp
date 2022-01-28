<%@page import="com.java.hib.EmployDAO"%>
<%@page import="com.java.hib.Gender"%>
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
<form method="get" action="EmployUpdate.jsp">
	<center>
		Employ No : 
		<input type="number" name="empno" /> <Br/><br/>
		Employ Name : 
		<input type="text" name="name" /> <br/><br/>
		Gender : 
		<input type="text" name="gender" /> <br/><br/> 
		Department : 
		<input type="text" name="dept" /> <br/><br/>
		Designation : 
		<input type="text" name="desig" /> <br/><Br/> 
		Basic : 
		<input type="number" name="basic" /> <br/><br/>
		<input type="submit" value="Update" />
	</center>
</form>
<%
if (request.getParameter("empno")!=null && request.getParameter("basic")!=null) {
	Employ employ = new Employ();
	employ.setEmpno(Integer.parseInt(request.getParameter("empno")));
	employ.setName(request.getParameter("name"));
	employ.setGender(Gender.valueOf(request.getParameter("gender")));
	employ.setDept(request.getParameter("dept"));
	employ.setDesig(request.getParameter("desig"));
	employ.setBasic(Integer.parseInt(request.getParameter("basic")));
	EmployDAO dao = new EmployDAO();
	dao.updateEmploy(employ);
}
%>

</body>
</html>