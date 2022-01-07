<%@page import="infinite11.ComplaintProjectJSP.Complaint"%>
<%@page import="infinite11.ComplaintProjectJSP.ComplaintDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="infinite11.ComplaintProjectJSP.ConnectionHelper"%>
<%@page import="java.sql.Connection"%>
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
	ComplaintDAO dao = new ComplaintDAO();
	Complaint[] arrComplaint = dao.showAllComplaint();
%>
<table border="10" align="center">
	<tr>
		<th>Complaint Id</th>
		<th>Complaint type</th>
		<th>Complaint description</th>
		<th>Complaint Date</th>
		<th>Severity </th>
		<th>Status</th>	
	</tr>
	<% 
	for(Complaint complaint:arrComplaint){
		if(complaint.getStatus()=="Pending"){		
%>
		<tr style="background-color: red;">
			<td><%=complaint.getComplaintId() %></td>
			<td><%=complaint.getComplaintType() %></td>
			<td><%=complaint.getCDescription() %></td>
			<td><%=complaint.getComplaintDate() %></td>
			<td><%=complaint.getSeverity() %></td>
			<td><%=complaint.getStatus() %></td>
		
		</tr>
<%
	}else{
%>

		<tr style="background-color: blue;">
		<td><%=complaint.getComplaintId() %></td>
		<td><%=complaint.getComplaintType() %></td>
		<td><%=complaint.getCDescription() %></td>
		<td><%=complaint.getComplaintDate() %></td>
		<td><%=complaint.getSeverity() %></td>
		<td><%=complaint.getStatus() %></td>
		</tr>
		<%
	
	}
		}
%>

</table>
<br><br><hr>
<a href="AddComplaint.jsp">Add Complaint here </a>

</body>
</html>