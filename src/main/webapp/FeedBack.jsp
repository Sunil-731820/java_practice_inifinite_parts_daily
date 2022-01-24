<%@page import="java.util.List"%>
<%@page import="com.java.hib.CollegeDAO"%>
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
	CollegeDAO c = new CollegeDAO();
	session.setAttribute("instructor", "none");
%>
<form action="FeedBack.jsp" method="get" name="frmFeedback">
	<center>
		Feed BacK Id:
		<input type="text" name="fId" readonly="readonly">
		Student Name:
		<input type="text" name="studentName"><br><br>
		
		Instructor :
		<select name="instructor" onchange="chonge()">
		<option value="Plaese Select">Please select</option>
		<%
		List<String> lstinstr=new CollegeDAO().getInstructors();
		for(String s: lstinstr){
		%>
		
		<option value="<%=s%>"> <%=s%> </option>
			<%		
		}
		 %>
		</select>
		
		<%
			String instr = request.getParameter("instructor");
			out.println(instr);
			session.setAttribute("instructor",instr);
		%>
		<br/>
		<input type="text" name="hidInstr" />
	</center>
</form>
<script>
	function change(){
		document.frmFeedback.submit();
		}

</script>

<%

session.setAttribute("fId",request.getParameter("fId"));
%>
<br><br><hr>
<% 
session.setAttribute("studentName",request.getParameter("studentName"));
%>

<br><br><hr>
<% 
session.setAttribute("subject",request.getParameter("subject"));
%>


<h1>Please give your feedback:</h1>
<form method="get" action="FeedBackConfirm.jsp">

	<br/><br/>
	select Subject : 
	<select name="subject">
	
		<%
		List<String> lstSubj = new CollegeDAO().getSubjects(instr);
		for(String s : lstSubj){
	%>
	
		<option value="<%=s%>"> <%=s%> </option>
	
	<%
		}
	%>
	</select> 
	
    <input type="radio" id="Choice1"
     name="feedback" value="Excellent"><br><br>
    <label for="Choice1">Excellent</label>

    <input type="radio" id="Choice2"
     name="feedback" value="Good"><br><br>
    <label for="Choice2">Good</label>

    <input type="radio" id="Choice3" 
     name="feedback" value="Adequate"><br><br>
    <label for="Choice3">Adequate</label>

    <input type="radio" id="Choice4"
     name="feedback" value="Inadequate"><br><br>
    <label for="Choice4">Adequate</label>
	<input type="submit" value="Show" />
</form>
 



</body>
</html>