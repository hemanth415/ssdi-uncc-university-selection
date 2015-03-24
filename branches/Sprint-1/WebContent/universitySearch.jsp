<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Search</title>
</head>
<body>
<form action="SearchUniversityController" method="post">
<div>
	<table>
		<tr>
			<td>
				University Name :	
			</td>
			<td>
				<input type="text" name="uName" value="${requestScope.uName}">	
			</td>
			<td>
				Country :	
			</td>
			<td>
				<input type="text" name="uCountry" value="${requestScope.uCountry}">	
			</td>
			<td>
				State :	
			</td>
			<td>
				<input type="text" name="uState" value="${requestScope.uState}">	
			</td>
		</tr>
	</table>
</div>
<div>
		<input type="submit" value="Search"/>
</div>
<div>
	<c:if test="${requestScope.result == true}">
		<table>
			<tr>
				<th>
					University Name
				</th>
				<th>
					University Description
				</th>
			</tr>
			<c:forEach items="${requestScope.uniList}" var="uni">
			<tr>
				<td><c:out value="${uni.universityName}"></c:out></td>
				<td><c:out value="${uni.universityDesc}"></c:out></td>
			</tr>
			</c:forEach>
		</table>	
	</c:if>
</div>
	</form>
</body>
</html>