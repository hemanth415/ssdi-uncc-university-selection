<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home</title>
</head>
<body background="images/snowflakes_on_light_purple.gif">
<div align="center">
	<h1>Your University Your Bank</h1>
		<h4 align="right">
			Hello
			<%=session.getAttribute("userName")%>
			<br> <a href="LogOutlink"> <b> LOGOUT </b>
			</a>
		</h4>
		<br> <br>
		<table>
			<tr>
				<th><a href="/Sprint-1/studentHome.jsp"> <b> HOME </b></a></th>
				<th><a href="/Sprint-1/universitySearch.jsp"> <b>
							SEARCH UNIVERSITIES </b></a></th>
				<th><a href=""> <b> SEARCH BANKS </b></a></th>
				<th><a href=""> <b> VIEW PROFILE </b></a></th>
			</tr>
		</table>
		<br> <br>
</div>
</body>
</html>