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
	String firstName = request.getParameter("firstName");
	Employ employ = dao.searchEmploy(firstName);
	%>
	<form method="get" action="UpdateEmploy.jsp">
		<center>
			Employ FirstName :
			<input type="text" name="firstName" readonly="readonly" value=<%=firstName %> ><br><br>
			Employ Last Name :
			<input type="text" name="lastName" value=<%=employ.getLastName() %>><br><br>
			Age :
			<input type="number" name="age" value=<%=employ.getAge() %>><br><br>
			Enter Location : 
			<input type="text" name="location" value=<%=employ.getLocation() %>><br><br>
			<input type="submit" value="Update Employ">
		</center>
	</form>
	<%
		if(request.getParameter("firstName")!=null && request.getParameter("age")!=null){
			Employ employUpdate = new Employ();
			employUpdate.setFirstName(request.getParameter("firstName"));
			employUpdate.setLastName(request.getParameter("lastName"));
			employUpdate.setAge(Integer.parseInt(request.getParameter("age")));
			employUpdate.setLocation(request.getParameter("location"));
			dao.updateEmploy(employUpdate);
			%>
			<jsp:forward page="EmployTable.jsp"></jsp:forward>
			<% 
		}
	%>
	


</body>
</html>