<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
tr.even {
	background: #80CEB9;
}

tr.odd {
	background: #41AAC4;
}
</style>
<title>Insert title here</title>
</head>
<body background="images/snowflakes_on_light_purple.gif">
	<form action="StudentProfileController" method="post">
		<center>
			<div>
				<h1>Your University Your Bank</h1>
				<h4 align="right">
					Hello
					<%=session.getAttribute("userName")%>
					<br> <a href=""> <b> LOGOUT </b>
					</a>
				</h4>
				<br>
				<c:choose>
					<c:when test="${sessionScope.userRole eq 83}">
						<table>
							<tr>
								<th><a href="/Sprint-1/studentHome.jsp"> <b> HOME </b></a></th>
								<th><a href="/Sprint-1/universitySearch.jsp"> <b>
											SEARCH UNIVERSITIES </b></a></th>
								<th><a href="searchBank"> <b> SEARCH BANKS </b></a></th>
								<th><a href="edityourprofilelink"> <b> VIEW PROFILE
									</b></a></th>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<table>
							<tr>
								<th><a href="/Sprint-1/welcome.jsp"> <b> HOME </b></a></th>
								<th><a href="/Sprint-1/universitySearch.jsp"> <b>
											SEARCH UNIVERSITIES </b></a></th>
								<th><a href="/Sprint-1/studentProfiles.jsp"> <b>
											STUDENT PROFILES </b></a></th>
								<th><a href=""> <b> POSTS </b></a></th>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
				<br>
			</div>
			<div>
				<table>
					<tr>
						<td><input type="checkbox" value="Spring-2015"
							name="spring2015" id="spring2015" /></td>
						<td>Spring 2015</td>
						<td><input type="checkbox" value="Fall-2015" name="fall2015"
							id="fall2015" /></td>
						<td>Fall 2015</td>
				</table>
				<br>
				<table>
					<tr>
						<td><input type="submit" value="Fetch Profiles" /></td>
					</tr>
				</table>
			</div>
			<br>
			<c:if test="${requestScope.studentMessage != null}">
				<c:out value="${requestScope.studentMessage}"></c:out>
			</c:if>
			<div>
				<c:if test="${requestScope.studentResult == true}">
					<br>
					<br>
					<table>
						<tr align="left" bgcolor="2F343A">
							<th align="left"><font color="white">Student Name</font></th>
							<th align="left"><font color="white">Address</font></th>
							<th align="left"><font color="white">Applied Term</font></th>
						</tr>
						<c:forEach items="${requestScope.studentList}" var="student"
							varStatus="loop">
							<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
								<td><c:out value="${student.firstName}"></c:out></td>
								<td><c:out value="${student.address}"></c:out></td>
								<td><c:out value="${student.appliedTerm}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</center>
	</form>
</body>
</html>