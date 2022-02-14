<%@page import="com.java.hib.Room"%>
<%@page import="java.util.List"%>
<%@page import="com.java.hib.RoomDAO"%>
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
			<th>Room Id </th>
			<th>Room Type</th>
			<th>Status</th>
			<th>cost Per Day</th>
			
		</tr>
		<%
			RoomDAO dao = new RoomDAO();
		List<Room> roomList = dao.showRoom();
		for(Room room: roomList){
		%>
			
			<tr>
				<td><%=room.getRoomId()%></td>
				<td><%=room.getType() %></td>
				<td><%=room.getStatus() %></td>
				<td><%=room.getCostPerDay() %></td>
			</tr>
			
		<%		
		}
		 %>

</body>
</html>