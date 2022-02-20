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
  

%>
<form method="get" action="AddEmploy.jsp">
	<center>
		Enter Employ First Name : 
			<input type="text" name="firstName"  /> <br/><br/>
			Enter Employ Last Name : 
			<input type="text" name="lastName" /> <br/><br/> 
			
			Enter Employ Age : 
			<input type="number" name="age" /> <br/><br/>
			Enter Employ LOcation : 
			<input type="text" name="location" /> <br/><br/> 
			 
			<input type="submit" value="Add Employ" />
	</center>>
</form>
	<%
		if (request.getParameter("firstName")!=null &&  
			request.getParameter("lastName") !=null
				) {
			Employ employ = new Employ();
			employ.setFirstName(request.getParameter("firstName"));
			employ.setLastName(request.getParameter("lastName"));
			employ.setAge(Integer.parseInt(request.getParameter("age")));
			employ.setLocation(request.getParameter("location"));
			
			dao.addEmploy(employ);
	%>
		<jsp:forward page="EmployTable.jsp"/>
	<%
		}
	%>
</body>
</html>