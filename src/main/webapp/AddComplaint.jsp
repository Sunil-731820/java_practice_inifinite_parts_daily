<%@page import="infinite11.ComplaintProjectJSP.Complaint"%>
<%@page import="infinite11.ComplaintProjectJSP.ComplaintDAO"%>
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
	%>
<form method="get" action="AddComplaint.jsp">
	<center>
		Complaint Id :
		<input type="text" name="ComplaintId"><br><br>
		ComplaintType :
		<input type="text" name="ComplaintType"><br><br>
		Complaint description :
		<input type="text" name="CDescription"><br><br>
		Complaint Date :
		<input type="date" name="ComplaintDate"><br><br>
		Severity :
		<input type="text" name="Severity"><br><br>
		Status :
		<input type="text" name="Status"><br><br>
		<input type="submit" value="Add Complaint">
	</center>
</form>

<%
	if(request.getParameter("ComplaintId")!=null){
		Complaint complaint = new Complaint();
		complaint.setComplaintId("ComplaintId");
		complaint.setComplaintType(request.getParameter("ComplaintType"));
		complaint.setCDescription(request.getParameter("CDescription"));
		complaint.setComplaintDate(request.getParameter("ComplaintDate"));
		complaint.setSeverity(request.getParameter("Severity"));
		complaint.setStatus(request.getParameter("Status"));
		dao.AddComplaint(complaint);

%>
<jsp:forward page="ShowAllComplaint.jsp"></jsp:forward>
<%
	}
%>



</body>
</html>