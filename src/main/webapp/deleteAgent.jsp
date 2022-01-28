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
<form action="deleteAgent.jsp" method="get">
	Agent  Number :
	<input type="text" name="agentId"><br><br>
	<input type="submit" value="delete">
</form>

<%
	if(request.getParameter("agentId")!=null){
		int agentId = Integer.parseInt(request.getParameter("agentId"));
		out.println(new AgentDAO().deleteAgent(agentId));
		
	}

%>

</body>
</html>