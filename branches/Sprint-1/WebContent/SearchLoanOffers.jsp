<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="SearchLoanOffers.css">  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
tr.even {
	background: #80CEB9;
}

tr.odd {
	background: #41AAC4;
}
</style>
<title>Search Loan Offers</title>
</head>
<%
	if("true".equalsIgnoreCase((String)request.getParameter("isHome"))){
		session.setAttribute("offersFoundStatus",false);
	}
%>
<body background="images/snowflakes_on_light_purple.gif">
	<form action="SearchLoanOfferController" method="post">
		<center>
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
						<td><input type="text" name="loanAmount"
							value="${requestScope.loanAmount}"></td>
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
				<c:if test="${sessionScope.offersFoundStatus == true}">
					<div align="left"></div>
					<br>
					<table>
						<tr align="left" bgcolor="2F343A">
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
						<c:forEach var="element" items="${sessionScope.resultList}" varStatus="loop">
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
        							<input type="submit" name="wishID" value="${element.postId}" 
        								onclick="{form.action='WishListController';}" />
        						</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</center>
	</form>
	<form action="ExcelExportController" method="post">
		<div align="center">
			<c:if test="${sessionScope.loanOffersResult == true}">
				<input type="submit" value="Excel Export"></input>
			</c:if>
		</div>
	</form>
</body>
</html>