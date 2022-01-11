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
	Agent[] arrAgent = dao.showAgent();
%>

<table>
	<tr>
		<th>Agent Id </th>
		<th> Name </th>
		<th>City  </th>
		<th>Gender </th>
		<th>Martial Status</th>
		<th>Premium</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<%
	for(Agent agent : arrAgent){
	%>	
		<tr>
			<td><%=agent.getAgentId() %></td>
			<td><%=agent.getName() %></td>
			<td><%=agent.getCity() %></td>
			<td><%=agent.getGender() %></td>
			<td><%=agent.getMaritalStatus() %></td>
			<td><%=agent.getPremium() %></td>
			<td><a href=UpdateAgent.jsp?agentId=<%=agent.getAgentId() %>>Update</a></td>
		    <td><a href=DeleteAgent.jsp?agentId=<%=agent.getAgentId() %>>Delete</a></td>
		
		
		</tr>
		
	
	<%	
	}
	
	%>
	
</table>

	<br><br>
	<hr>
	<a href="AddAgent.jsp"> Add Agent Here </a>
</body>
</html>