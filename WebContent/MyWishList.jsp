<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="SearchLoanOffers.css"> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>My Wish List</title>
<style type="text/css">
tr.even {
	background: #dae5f4;
}

tr.odd {
	background: #b8d1f3;
}
</style>
</head>

<body background="images/snowflakes_on_light_purple.jpg">
	<form action="GetWishListDataController" method="post">
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
								<th><a href="/Sprint-1/SearchLoanOffers.jsp?isHome=true">
										<b> SEARCH BANKS </b>
								</a></th>
								<th><a href="/Sprint-1/Buffer.jsp"><b>WISH LIST</b></a></th>
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
								<th><a href="/Sprint-1/postLoanOffers.jsp"> <b>
											POSTS </b></a></th>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<br>
			<c:if test="${requestScope.message != null}">
				<c:out value="${requestScope.message}"></c:out>
			</c:if>
			<div>
				<c:if test="${requestScope.result == true}">
					<br>
					<table>
						<tr align="left" bgcolor="#41AAC4">
							<!-- <th align="left" width="5%">ID</th> -->
							<th align="left" width="10%">Bank Name</th>
							<th align="left" width="10%">Loan Officer</th>
							<th align="left" width="10%">Telephone</th>
							<th align="left" width="10%">Email</th>
							<th align="left" width="5%">Interest</th>
							<th align="left" width="10%">Loan amount</th>
							<th align="left" width="25%">Loan details</th>
						</tr>

						<c:forEach var="element" items="${resultList}" varStatus="loop">
							<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
								<%--         						<td>
        							<input type="submit" id="wishID" value="${element.postId}" 
        								onclick="" />
        						</td> --%>
								<td>${element.bankName}</td>
								<td>${element.loanOfficer}</td>
								<td>${element.telephone}</td>
								<td>${element.email}</td>
								<td>${element.interestRate}</td>
								<td>${element.loanAmount}</td>
								<td>${element.loanDetails}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</center>
	</form>
</body>
</html>