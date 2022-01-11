<%@page import="com.java.lang.agent.AgentDAO"%>
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
	int agentId = Integer.parseInt(request.getParameter("agentId"));
	AgentDAO dao = new AgentDAO();
	dao.deleteAgent(agentId);
%>
<jsp:forward page="AgentTable.jsp"></jsp:forward>
</body>
</html>