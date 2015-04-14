<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="SearchLoanOffers.css">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>Search Loan Offers</title>
	
</head>

<body background="images/snowflakes_on_light_purple.gif">
	<form action="SearchLoanOfferController" method="post">
		<center>
			<div>
				<table class="noBorder">
					<tr >
						<td class="noBorder">University Name :</td>
						<td class="noBorder">
							<select name="universityID" id="universityID">
								<option value="1">Loans common to all Universities</option>
								<option value="50000">The University of North Carolina at Chapel Hill</option>
								<option value="50001">The University of North Carolina at Charlotte</option>
								<option value="50002">North Carolina State University</option>
							</select>
						</td>
						
						<td class="noBorder">Country:</td>
						<td class="noBorder">
							<select name="loanCountry" id="loanCountryID">
								<option value="US">United States Of America</option>
								<option value="INDIA">INDIA</option>
							</select>
						</td>
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
					<table >
						<tr align="center" style="border: 1px solid black">
							<th align="center" width="10%">Bank Name</th>
							<th align="center" width="10%">Loan Officer</th>
							<th align="center" width="10%">Telephone</th>
							<th align="center" width="10%">Email</th>
							<th align="center" width="10%">Interest rate</th>
							<th align="center" width="10%">Loan amount</th>
							<th align="center" width="25%">Loan details</th>
						</tr>
						
						<c:forEach var="element" items="${resultList}">
        					<tr>
					            <td>${element.bankName}</td> 
					            <td>${element.loanOfficerName}</td>
					            <td>${element.bankerContactNum}</td>
					            <td>${element.bankerEmailId}</td>
					            <td>${element.interestRate}</td>
					            <td>${element.maxLoanAmount}</td>
					            <td>${element.loanDescription}</td>
					        </tr> 
					    </c:forEach>
					</table>
				</c:if>
			</div>
		</center>
	</form>
</body>
</html>