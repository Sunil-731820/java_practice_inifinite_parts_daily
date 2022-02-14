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

<table  border="10px solid black" bordercolor="red" align="center">
	<form method="get" action="SearchRoom.jsp">
		Enter Room Id :
			<input type="text" name="roomId"><br><br>
			<input type="submit" value="search"><br><br>
	</form>
	
	<%
	if(request.getParameter("roomId")!=null){
		String roomId = request.getParameter("roomId");
		Room room = new RoomDAO().searchRoom(roomId);
		if(room!=null){
			out.println("Room Type " + room.getType()+"<br><br>");
			out.println("Room Status " + room.getStatus()+"<br><br>");
			out.println("Room cost Per Day " + room.getCostPerDay()+"<br><br>");
			
		}else{
			out.println("Room Not available");
		}
	}
	
	%>
</table>

</body>
</html>