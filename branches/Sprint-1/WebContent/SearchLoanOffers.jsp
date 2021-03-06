<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="SearchLoanOffers.css">  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
/* tr.even {
	background: #80CEB9;
}

tr.odd {
	background: #41AAC4;
} */
tr.even {
	background: #dae5f4;
}

tr.odd {
	background: #b8d1f3;
}
</style>
<title>Search Loan Offers</title>
</head>
<%
	if ("true"
			.equalsIgnoreCase((String) request.getParameter("isHome"))) {
		session.setAttribute("offersFoundStatus", false);
	}
%>
<body background="images/snowflakes_on_light_purple.jpg">
	<form action="SearchLoanOfferController" method="post">
		<center>
			<div>
				<h1>Your University Your Bank</h1>
				<h4 align="right">
					Hello
					<%=session.getAttribute("userName")%>
					<br> <a href="Logout"> <b> LOGOUT </b>
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
			<div>
				<table>
					<tr>
						<td>University Name</td>
						<td><select name="universityID" id="universityID">
								<option value="1">Loans common to all Universities</option>
								<option value="50000">The University of North Carolina
									at Chapel Hill</option>
								<option value="50001">The University of North Carolina
									at Charlotte</option>
								<option value="50002">North Carolina State University</option>
						</select></td>
						<td>Country</td>
						<td><select name="loanCountry" id="loanCountryID">
								<option value="US">United States Of America</option>
								<option value="INDIA">INDIA</option>
						</select></td>
						<td>Loan Amount Required</td>
						<td>
						<td><input type="number" name="loanAmount" min="0"
							value="${requestScope.loanAmount}"></td>
					</tr>
				</table>
			</div>
			<br> <br>
			<div>
				<table>
					<tr>
						<td><input type="submit" value="Search"
							onclick="{form.action='SearchLoanOfferController';}" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
				</table>
			</div>
			<br>
			<c:if test="${requestScope.message != null}">
				<c:out value="${requestScope.message}"></c:out>
			</c:if>
			<div>
				<c:if test="${sessionScope.offersFoundStatus == true}">
					<div align="left"></div>
					<br>
					<table>
						<tr align="left" bgcolor="#41AAC4">
							<th align="left" width="7%">Bank Name</th>
							<th align="left" width="10%">Offer Name</th>
							<th align="left" width="10%">Loan Officer</th>
							<th align="left" width="8%">Telephone</th>
							<th align="left" width="10%">Email</th>
							<th align="left" width="7%">Interest Rate</th>
							<th align="left" width="4%">Period</th>
							<th align="left" width="8%">Pre-Payment</th>
							<th align="left" width="7%">Installment</th>
							<th align="left" width="24%">Loan details</th>
							<th align="center" width="5%">ADD to WishList</th>
						</tr>
						<c:forEach var="element" items="${sessionScope.loanOffers}"
							varStatus="loop">
							<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
								<td>${element.bankName}</td>
								<td>${element.offerName}</td>
								<td>${element.loanOfficerName}</td>
								<td>${element.bankerContactNum}</td>
								<td>${element.bankerEmailId}</td>
								<td>${element.interestRate}</td>
								<td>${element.duration}</td>
								<td>${element.prePaymentValue}</td>
								<td>${element.installments}</td>
								<td>${element.loanDescription}</td>
								<td align="center">
									<%-- <input type="submit" name="wishID" value="${element.postId}" 
        								onclick="{form.action='WishListController';}" /> --%> <c:choose>
										<c:when test="${element.wishListStatus == null}">
											<button type="submit" name="add" value="${element.postId}"
												onclick="{form.action='WishListController';}">ADD</button>
										</c:when>
										<c:otherwise>
											<button type="submit" name="remove" value="${element.postId}"
												onclick="{form.action='WishListController';}">Remove</button>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div align="center">
						<c:if test="${sessionScope.loanOffersResult == true}">
							<button type="submit" name="report" value="true"
								onclick="{form.action='ExcelExportController';}">Excel
								Export</button>
							<!-- <input type="submit" value="Excel Export"></input> -->
						</c:if>
					</div>
				</c:if>
			</div>
		</center>
	</form>
	<%-- <form action="ExcelExportController" method="post">
		<div align="center">
			<c:if test="${sessionScope.loanOffersResult == true}">
				<input type="submit" value="Excel Export"></input>
			</c:if>
		</div>
	</form> --%>
</body>
</html>