<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddSuject.jsp" method="post" name="productForm">
	Subject Id :
	<input type="number" name="subjectId"><br><br>
	<select name="subject" id="dropdown" onchange="change()">
				<option value="dropdown">Please choose Subjects Here</option>
				<option value="PC Architecture">PC Architecture</option>
                <option value="PC Hardware 1">PC Hardware 1</option>
                <option value="PC Hardware 2">PC Hardware 2</option>
                <option value="Microprocessor Interfacing">Microprocessor Interfacing</option>
                <option value="C#">C#</option>
                <option value="Operating System">Operating System</option>
                <option value="SQL Server">SQL Server</option>
                <option value="Networking">Networking</option>
	</select>
	<br><br>
	Theory :
	<input type="text" id="theory" name="theory" readonly="readonly"><br><br>
	Practical :
	<input type="text" name="practical" id="practical" readonly="readonly"><br><br>
	Year :
	<input type="number" name="year"><br><br>
	Instructor :
	<input type="text" name="instructor"><br><br>
	 <input type="submit" value="Add Subject">
</form>
 <%
        String colour = request.getParameter("colour");
        out.println(colour);
        %>

<script>
 function change(){
	 var dval = document.getElementById("dropdown").value;
	 if(dval =="PC Architecture"){
     	productForm.theory.value="42";
     	productForm.practical.value="14";
     }
     if(dval =="PC Hardware 1"){
     	productForm.theory.value="90";
     	productForm.practical.value="50";
     }
     if(dval =="PC Hardware 2"){
     	productForm.theory.value="69";
     	productForm.practical.value="41";
     }
     
     if(dval =="PC Hardware 2"){
     	productForm.theory.value="69";
     	productForm.practical.value="41";
     }
     
     if(dval =="Microprocessor Interfacing"){
     	productForm.theory.value="107";
     	productForm.practical.value="93";
     }
     
     if(dval =="C#"){
     	productForm.theory.value="84";
     	productForm.practical.value="56";
     }
     
     if(dval =="Data Structures"){
     	productForm.theory.value="60";
     	productForm.practical.value="0";
     }
     
     if(dval =="Operating System"){
     	productForm.theory.value="80";
     	productForm.practical.value="70";
     }
     
     if(dval =="SQL Server"){
     	productForm.theory.value="66";
     	productForm.practical.value="34";
     }
     
     if(dval =="Networking"){
     	productForm.theory.value="94";
     	productForm.practical.value="156";
     }
}
 document.getElementById("dropdown").value='<% out.print(colour); %>';
</script>

</body>
</html>