<%@page import="com.java.hib.Feedback"%>
<%@page import="java.util.List"%>
<%@page import="com.java.hib.CollegeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="10" align="center">
	<tr>
		<th>FId</th>
		<th>Student Name</th>
		<th>Instructor</th>
		<th>subjects</th>
		<th>Fbvalue</th>
	</tr>
	<%
	CollegeDAO dao = new CollegeDAO();
	List<Feedback> feedBackList = dao.showFeedBack();
	for(Feedback feedback:feedBackList){
	%>
	
	<tr>
		<td><%=feedback.getfId()%></td>
		<td><%=feedback.getStudentName()%></td>
		<td><%=feedback.getInstructor()%></td>
		<td><%=feedback.getSubject()%></td>
		<td><%=feedback.getFbValue()%></td>
	
	</tr>
		
	<%
	}
	 %>
	

</table>



</body>
</html>