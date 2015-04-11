<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Search</title>
</head>
<body background="images/snowflakes_on_light_purple.gif">
	<form action="SearchUniversityController" method="post">
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
								<th><a href="postLink"> <b> POSTS </b></a></th>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
				<br>
			</div>
			<div>
				<table>
					<tr>
						<td>University Name :</td>
						<td><input type="text" name="uName"
							value="${requestScope.uName}"></td>
						<td>Country :</td>
						<td><input type="text" name="uCountry"
							value="${requestScope.uCountry}"></td>
						<td>State :</td>
						<td><input type="text" name="uState"
							value="${requestScope.uState}"></td>
					</tr>
				</table>
			</div>
			<br> <br>
			<div>
				<table>
					<tr>
						<td><input type="submit" value="Search" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
				</table>
			</div>
			<br>
			<c:if test="${requestScope.message != null}">
				<c:out value="${requestScope.message}"></c:out>
			</c:if>
			<div>
				<c:if test="${requestScope.result == true}">
					<br>
					<br>
					<table>
						<tr align="left" bgcolor="blue">
							<th align="left" width="20%">University Name</th>
							<th align="left" width="35%">University Description</th>
							<th align="left" width="20%">University Address</th>
							<th align="left" width="15%">University Contact</th>
							<th align="left" width="10%">University E-Mail</th>
						</tr>
						<c:forEach items="${requestScope.uniList}" var="uni">
							<tr>
								<td><c:out value="${uni.universityName}"></c:out></td>
								<td><c:out value="${uni.universityDesc}"></c:out></td>
								<td><c:out value="${uni.address}"></c:out></td>
								<td><c:out value="${uni.contact}"></c:out></td>
								<td><c:out value="${uni.eMail}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</center>
	</form>
</body>
</html>