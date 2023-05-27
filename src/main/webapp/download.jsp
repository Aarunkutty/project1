<%@page import="studentDataTransferObject.StudentDTO"%>
<%@page import="java.util.List"%>
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
	List<StudentDTO> dtos = (List<StudentDTO>) request.getAttribute("studentlist");
	%>
	<table border="">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>PhoneNo</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<%
		for (StudentDTO dto : dtos) {
		%>
		<tr>
			<td><%=dto.getsID()%></td>
			<td><%=dto.getStudentName()%></td>
			<td><%=dto.getGender()%></td>
			<td><%=dto.getEmail()%></td>
			<td><%=dto.getPhone()%></td>
			<td><a href="delete?sid=<%=dto.getsID()%>">Delete</a></td>
			<td><a
				href="updated3.jsp?sid=<%=dto.getsID()%>
			&name=<%=dto.getStudentName()%>
			&email=<%=dto.getEmail()%>
			&gender2=<%=dto.getGender()%>
			&phone=<%=dto.getPhone()%>">update</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<a href="index.jsp"><button id="butt2">homepage</button></a>
</body>
</html>