<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Loan Offers</title>
<script>
	function validateForm() {
		/* 				var bankName = document.getElementById("bankNameID");
		 var contactPerson = document.getElementById("contactPersonID");
		 var contactNum = document.getElementById("contactNumID");
		 var contactEmail = document.getElementById("contactEmailID");
		 var bankAddress = document.getElementById("bankAddressID");
		 var bankZipCode = document.getElementById("bankZipCodeID");
		 var country = document.getElementById("countryID");
		 var universityName = document.getElementById("universityNameID");
		 var interestRate = document.getElementById("interestRateID");
		 var maxLoanAmount = document.getElementById("maxLoanAmountID");
		 var loanDescription = document.getElementById("loanDescriptionID");

		 if (bankName.value.length <= 0) {
		 alert("Please enter your Bank's name");
		 return false;
		 } else if (contactPerson.value.length <= 0) {
		 alert("Please enter your Full name");
		 return false;
		 } else if ((isNaN(contactNum.value))
		 || (contactNum.value.indexOf(" ") != -1) || (contactNum.value.length <= 9)) {
		 alert("Please enter a valid phoneNumber");
		 return false;
		 } else if (contactEmail.value.length <= 0) {
		 alert("Please enter a valid email");
		 return false;
		 } else if (bankAddress.value.length <= 0) {
		 alert("Please enter the Bank's address");
		 return false;
		 } else if (isNaN(bankZipCode.value)
		 || (bankZipCode.value.indexOf(" ") != -1)  (bankZipCode.value.length <= 5)) {
		 alert("Please enter a valid Zip code");
		 return false;
		 } else if (country.value.length <= 0) {
		 alert("Please enter country");
		 return false;
		 } else if (universityName.value.length <= 0) {
		 alert("Please select university");
		 return false;
		 } else if (isNaN(interestRate.value)
		 || (interestRate.value.indexOf(" ") != -1)  (interestRate.value.length <= 0)) {
		 alert("Please enter the interest rate");
		 return false;
		 } else if (isNaN(maxLoanAmount.value)
		 || (maxLoanAmount.value.indexOf(" ") != -1)) {
		 alert("Please enter the maimum loan amount");
		 return false;
		 } else if (loanDescription.value.length <= 0) {
		 alert("Enter some description!!");
		 return false;
		 } */
	}
</script>
</head>

<body background="images/snowflakes_on_light_purple.gif">
	<form action="PostLoanOffersController"
		onsubmit="return validateForm();" method="post">
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
			</div>
			<h3 align="center">Enter Loan Offer Details</h3>
			<div>
				<c:if test="${requestScope.message != null}">
					<c:out value="${requestScope.message}"></c:out>
				</c:if>
			</div>
			<table align="center">
				<tr>
					<td>Post Name :</td>
					<td><input type="text" name="postName" id="postNameID"
						value="${requestScope.bankName}"></td>
				</tr>

				<tr>
					<td>University name:</td>
					<td><select name="universityName" id="universityNameID">
							<option value="50000">The University of North Carolina
								at Chapel Hill</option>
							<option value="50001">The University of North Carolina
								at Charlotte</option>
							<option value="50002">North Carolina State University</option>
					</select></td>
				</tr>

				<tr>
					<td>Loan Features :</td>
					<td><textarea rows="4" cols="50" name="loanFeatures"
							id="loanFeaturesID"></textarea></td>
				</tr>

				<tr>
					<td>Mandatory Documents :</td>
					<td><textarea rows="4" cols="50" name="mandtoryDocs"
							id="mandtoryDocsID"></textarea></td>
				</tr>

				<tr>
					<td>Interest rate(in numbers):</td>
					<td><input type="text" name="interestRate" id="interestRateID"
						value="${requestScope.interestRate}"></td>
				</tr>

				<tr>
					<td>Max loan amount(in numbers):</td>
					<td><input type="text" name="maxLoanAmount"
						id="maxLoanAmountID" value="${requestScope.maxLoanAmount}"></td>
				</tr>

			</table>
			<br> <br>
			<table align="center">
				<tr>
					<td><input type="submit" value="Post Offer" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>