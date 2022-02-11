<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.java.jsp.Room"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="RoomSearch.jsp">
<center>
	Enter the Room ID Here:
		<input type="text" name="roomId"><br><br>
		<input type="submit" value="Search Room">
</center>
<%
		if (request.getParameter("roomId")!=null) {
			String a = request.getParameter("roomId");
			URL url = new URL("http://localhost:8182/room/"+a);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "application/json");
		        if (conn.getResponseCode() != 200) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                    + conn.getResponseCode());
		        }
		        BufferedReader br = new BufferedReader(new InputStreamReader(
		            (conn.getInputStream())));
		        String output;
		        String res="";
		        while ((output = br.readLine()) != null) {
		        	res+=output;
		        }
		      Room room = new ObjectMapper().readValue(res, Room.class);
		    out.println("Room Id " + room.getRoomid()+ "<br/>");
		    out.println("Type "+ room.getType()+"<br/>");
		    out.println("Status " + room.getStatus()+"<br/>");
		    out.println("Cost Per Day "+ room.getCostperday()+"<br/>");
		}
	%>
		

</form>
</body>
</html>