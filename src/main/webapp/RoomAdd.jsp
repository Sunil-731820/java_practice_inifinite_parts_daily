<%@page import="com.java.hib.RoomDAO"%>
<%@page import="com.java.hib.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="10px" align="center">
	<form method="get" action="RoomAdd.jsp">
	
	Enter the Room Id Here :
	<input type="text" name="roomId"><br><br>
	Enter the Room Type:
	<input type="text" name="type"><br><br>
	Enter the Room Status 
	<input type="text" name="status"><br><br>
	Enter the Room Cost :
	<input type="number" name="costPerDay"><br><br>
	<input type="submit" value="AddRoom">
	</form>
</table>

<%
	if(request.getParameter("roomId")!=null && request.getParameter("costPerDay")!=null){
		Room room = new Room();
		room.setRoomId(request.getParameter("roomId"));
		room.setType(request.getParameter("type"));
		room.setStatus(request.getParameter("status"));
		room.setCostPerDay(Integer.parseInt(request.getParameter("costPerDay")));
		RoomDAO dao = new RoomDAO();
		out.println(dao.addRoom(room));
	}
%>

</body>
</html>