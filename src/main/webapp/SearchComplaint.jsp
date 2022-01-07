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
	<form method="get" action="SearchComplaint.jsp">
		<center>
			Complaint Id :
			<input type="text" name="ComplaintId"><br><br>
			<input type="submit" value="search Complaint">
		</center>
	</form>
	
	<%
	if(request.getParameter("ComplaintId")!=null){
		String ComplaintId = request.getParameter("ComplaintId");
		Connection con = ConnectionHelper.getConnection();
		String cmd  = "select *from complaint where ComplaintId=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setString(1, request.getParameter("ComplaintId"));
		ResultSet res = pst.executeQuery();
		if(res.next()){
			out.println("ComplaintType is     :" + res.getString("ComplaintType")+"<br>");
			out.println("Complaint Description    :" + res.getString("CDescription")+"<br>");
			out.println("ComplaintDate    :" + res.getDate("ComplaintDate")+"<br>");
			out.println("Severity is     "+ res.getString("Severity")+"<br>");
			out.println("Status is   : " + res.getString("Status")+"<br>");
		}
	}
	
	
	%>
</body>
</html>