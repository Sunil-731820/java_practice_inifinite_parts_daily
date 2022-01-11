<%@page import="com.java.lang.agent.Gender"%>
<%@page import="org.glassfish.jersey.client.RequestEntityProcessing"%>
<%@page import="com.java.lang.agent.Agent"%>
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
	AgentDAO dao = new AgentDAO();
	int agentId = Integer.parseInt(request.getParameter("agentId"));
	Agent agent = dao.searchAgent(agentId);
%>

<form mathod="get" action="UpdateAgent.jsp">
	<center>
		Agent Id :
		<input type="number" name="agentId" readonly="readonly" value=<%=agentId %>><br><br>
		Name :
		<input type="text" name="Name" value=<%=agent.getName() %>><br><br>
		City : 
		<input type="text" name="City" value=<%=agent.getCity() %>><br><br>
		Gender :
		<input type="text" name="GENDER" value=<%=agent.getGender() %>><br><br>
		MaritalStatus :
		<input type="number" name="MaritalStatus" value=<%=agent.getMaritalStatus() %>><br><br>
		Premium :
		<input type="number" name="Premium" value=<%=agent.getPremium() %>><br>
	<br>
	<input type="submit" value="Update Agent ">
	</center>
</form>
<%
	if(request.getParameter("agentId")!=null && request.getParameter("Premium")!=null){
		Agent agentUpdate = new Agent();
		agentUpdate.setAgentId(Integer.parseInt(request.getParameter("agentId")));
		agentUpdate.setName(request.getParameter("Name"));
		agentUpdate.setCity(request.getParameter("City"));
		agentUpdate.setGender(Gender.valueOf(request.getParameter("GENDER")));
		agentUpdate.setMaritalStatus(Integer.parseInt(request.getParameter("MaritalStatus")));
		agentUpdate.setPremium(Double.parseDouble(request.getParameter("Premium")));
		dao.updateAgent(agentUpdate);

%>
<jsp:forward page="AgentTable.jsp"></jsp:forward>

<%
	}
%>

</body>
</html>