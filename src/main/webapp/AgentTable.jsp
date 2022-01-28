<%@page import="com.java.hib.Agent"%>
<%@page import="java.util.List"%>
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
<table border="10" align="center">
		<tr>
			<th>Agent Number</th>
			<th>Agent Name</th>
			<th>City</th>
			<th>Gender</th>
			<th>maritalStatus</th>
			<th>Premium</th>
		</tr>
		<%
			AgentDAO dao = new AgentDAO();
		List<Agent> agentList = dao.showAgent();
		for(Agent agent: agentList){
		%>
			
			<tr>
				<td><%=agent.getAgentId()%></td>
				<td><%=agent.getName()%></td>
				<td><%=agent.getCity() %></td>
				<td><%=agent.getGender() %></td>
				<td><%=agent.getMaritalStatus() %></td>
				<td><%=agent.getPremium() %></td>
			</tr>
			
		<%		
		}
		 %>
	</table>

</body>
</html>