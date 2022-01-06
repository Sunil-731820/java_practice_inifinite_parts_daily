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
   int empno = dao.generateEmployNo();

%>
<form method="get" action="AddEmploy.jsp">
	<center>
		Enter Employ No : 
			<input type="number" name="empno" value=<%=empno %> /> <br/><br/>
			Enter Employ Name : 
			<input type="text" name="name" /> <br/><br/> 
			choose Gender :
			<select name="gender">
				<option value="MALE">Male</option>
				<option value="FEMALE">Female</option>
			</select> <br/><br/> 
			Enter Department : 
			<input type="text" name="dept" /> <br/><br/>
			Enter Designation : 
			<input type="text" name="desig" /> <br/><br/> 
			Enter Basic : 
			<input type="number" name="basic" /> <br/><br/> 
			<input type="submit" value="Add Employ" />
	</center>>
</form>
	<%
		if (request.getParameter("empno")!=null &&  
			request.getParameter("name") !=null
				) {
			Employ employ = new Employ();
			employ.setEmpno(empno);
			employ.setName(request.getParameter("name"));
			employ.setGender(request.getParameter("gender"));
			employ.setDept(request.getParameter("dept"));
			employ.setDesig(request.getParameter("desig"));
			employ.setBasic(Integer.parseInt(request.getParameter("basic")));
			dao.addEmploy(employ);
	%>
		<jsp:forward page="EmployTable.jsp"/>
	<%
		}
	%>
</body>
</html>