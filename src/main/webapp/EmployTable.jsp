<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.java.hib.Employ"%>
<%@page import="java.util.List"%>
<%@page import="com.java.hib.EmployDAO"%>
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
			<th>Employ number</th>
			<th>Employ Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
		</tr>
		<%
			EmployDAO dao = new EmployDAO();
		List<Employ> employList = dao.showEmploy();
		for(Employ employ: employList){
		%>
			
			<tr>
				<td><%=employ.getEmpno()%></td>
				<td><%=employ.getName()%></td>
				<td><%=employ.getGender() %></td>
				<td><%=employ.getDept() %></td>
				<td><%=employ.getDesig() %></td>
				<td><%=employ.getBasic() %></td>
			</tr>
			
		<%		
		}
		 %>
	</table>

</body>
</html>