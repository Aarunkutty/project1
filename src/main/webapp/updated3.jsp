<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="updated" id ="upda">
	
	Id : <input type="number" name="id" value=<%=request.getParameter("sid") %> readonly="readonly""><br>
	Name : <input type="text" name="sname" value=<%=request.getParameter("name") %>><br>
	Gender:<%
	if(request.getParameter("gender2").equals("Male")){%>
		Male<input type="radio" id ="gender" name="gender" value="Male" checked="checked">
		Female<input type="radio" id ="gender" name="gender" value="Female"><br>
	<% }else{%>
		
		Male<input type="radio" id ="gender" name="gender" value="Male" >
		Female<input type="radio" id ="gender" name="gender" value="Female" checked="checked"><br>
	<% }
	%>
	Email : <input type="text" name="semail" value=<%=request.getParameter("email") %>><br>
	Phone No : <input type="number" name="sphone" value=<%=request.getParameter("phone") %>><br>
	
	</form>
	
		<button form="upda">Submit</button>
		<a href="fetchallsd"><button>Cancel</button></a>
</body>
</html>