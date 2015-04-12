<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banker Home</title>
</head>
<body background="images/snowflakes_on_light_purple.gif">
	<div align="center">
		<h1>Your University Your Bank</h1>
		<h4 align="right">
			Hello
			<%=session.getAttribute("userName")%>
			<br> <a href=""> <b> LOGOUT </b>
			</a>
		</h4>
		<br> <br>
		<table>
			<tr>
				<th><a href="/Sprint-1/welcome.jsp"> <b> HOME </b></a></th>
				<th><a href="/Sprint-1/universitySearch.jsp"> <b>
							SEARCH UNIVERSITIES </b></a></th>
				<th><a href="/Sprint-1/studentProfiles.jsp"> <b>
							STUDENT PROFILES </b></a></th>
				<th><a href="/Sprint-1/postLoanOffers.jsp"> <b> POSTS </b></a></th>
			</tr>
		</table>
		<br>
	</div>
</body>
</html>