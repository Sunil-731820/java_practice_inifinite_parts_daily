<%@page import="com.java.hib.Agent"%>
<%@page import="com.java.hib.AgentDAO"%>
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
	<form method="get" action="AgentSearch.jsp">
		Agent Number :
			<input type="number" name="agentId"><br><br>
			<input type="submit" value="search"><br><br>
	</form>
	<%
	if (request.getParameter("agentId") !=null) {
		int agentId = Integer.parseInt(request.getParameter("agentId"));
		Agent agent = new AgentDAO().searchAgent(agentId);
		if(agent!=null){
			out.println("Agent Name " + agent.getName()+"<br><br>");
			out.println("City is  " + agent.getCity()+"<br><br>");
			out.println("Gender is  " + agent.getGender()+"<br><br>");
			out.println("MaritalStatus   is " + agent.getMaritalStatus()+"<br><br>");
			out.println("premium is  " + agent.getPremium()+"<br><br>");
		}else{
			out.println(" Agents Records Not Found ");
		}
			
		}
	
	%>
	
</table>

</body>
</html>