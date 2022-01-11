<%@page import="com.java.lang.agent.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="LoginPage.jsp">
	<center>
	<h1>Please Login To access the Dashborad</h1>
	Enter userName :
	<input type="text" name="userName"><br><br>
	Enter passcode :
	<input type="text" name="passCode"><br><br>
	<input type="submit" value="Login">	
	</center>
</form>

	<%
		if (request.getParameter("userName")!=null && 
			request.getParameter("passCode") !=null
				) {
			String userName = request.getParameter("userName").trim();
			String passCode = request.getParameter("passCode").trim();
			UsersDAO dao = new UsersDAO();
			int count = dao.validate(userName, passCode);
			if (count==1) {
	%>
		<jsp:forward page="AgentTable.jsp"/>
	<%
			} else {
				out.println("Sorry your userName & passcode is invalid");
			}
		}
	%>



</body>
</html>