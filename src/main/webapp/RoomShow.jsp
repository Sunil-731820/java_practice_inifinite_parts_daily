<%@page import="com.java.jsp.Room"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
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
<table border="3">
<tr>
	<th>Room Id</th>
	<th>Room Type</th>
	<th>Status</th>
	<th>Cost Per Day </th>
	
	
</tr>

<%
		 URL url = new URL("http://localhost:8182/showRoom");
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
	        ObjectMapper objectMapper = new ObjectMapper();
	        Room[] room = objectMapper.readValue(res, Room[].class);
	        for(Room r : room) {
  %>
  	<tr>
  		<td> <%=r.getRoomid() %> </td>
  		<td> <%=r.getType() %> </td>
  		<td> <%=r.getStatus() %> </td>
  		<td> <%=r.getCostperday() %> </td>
  		
  	</tr>
  <%
	       	
	        }
	  %>
	  </table>

</body>
</html>