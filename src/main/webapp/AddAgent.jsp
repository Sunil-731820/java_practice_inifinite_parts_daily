<%@page import="com.java.lang.agent.Gender"%>
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
	int agentId = dao.generateAgentNo();
	
%>

<form method="get" action="AddAgent.jsp">
	<center>
		Agent Id :
		<input type="number" name="agentId" value=<%=agentId %>><br><br>
		Name :
		<input type="text" name="Name"><br><br>
		City :
		<input type="text" name="City"><br><br>
		choose Gender :
			<select name="GENDER">
				<option value="MALE">Male</option>
				<option value="FEMALE">Female</option>
			</select> <br/><br/> 
		MartialStatus :
		<input type="number" name="MaritalStatus"><br><br>
		Premium:
		<input type="number" name="Premium"><br><br>
		<input type="submit" value="add Agent">
	</center>
</form>
<%

	if(request.getParameter("agentId")!=null){
		Agent agent = new Agent();
		agent.setAgentId(agentId);
		agent.setName(request.getParameter("Name"));
		agent.setCity(request.getParameter("City"));
		agent.setGender(Gender.valueOf(request.getParameter("GENDER")));
		agent.setMaritalStatus(Integer.parseInt(request.getParameter("MaritalStatus")));
		agent.setPremium(Double.parseDouble(request.getParameter("Premium")));
		dao.addAgent(agent);
		%>
		
		
		<jsp:forward page="AgentTable.jsp"></jsp:forward>
	<%	
	}
%>



</body>
</html>