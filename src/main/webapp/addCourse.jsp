<%@page import="com.java.hib.CollegeDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="com.java.hib.CourseList"%>
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
	CourseList courseList = new CourseList();
	courseList.setCourseNo(request.getParameter("courseNo"));
	courseList.setDuration(Integer.parseInt(request.getParameter("duration")));
	Date sDate = Date.valueOf(request.getParameter("startDate"));
	Date eDate = Date.valueOf(request.getParameter("endDate"));
	courseList.setStartDate(sDate);
	courseList.setEndDate(eDate);
	courseList.setHod(request.getParameter("hod"));
	
	CollegeDAO obj = new CollegeDAO();
	obj.addCourse(courseList);
	out.println("**********Course Added Successfully ******");
%>

</body>
</html>