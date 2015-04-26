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
		var postName = document.getElementById("postNameID");
		var universityName = document.getElementById("universityNameID");
		var loanFeatures = document.getElementById("loanFeaturesID");
		var mandtoryDocs = document.getElementById("mandtoryDocsID");
		var interestRate = document.getElementById("interestRateID");
		var maxLoanAmount = document.getElementById("maxLoanAmountID");
		
		if (postName.value.length <= 0) {
			 alert("Please enter a name for your post");
			 return false;
		} else if (universityName.value.length <= 0) {
			 alert("Please select an University");
			 return false;
		} else if (loanFeatures.value.length <= 0) {
			 alert("Please enter loan features / description");
			 return false;
		} else if (mandtoryDocs.value.length <= 0) {
			 alert("Please enter the mandotory documents to be submitted");
			 return false;
		} else if ((isNaN(interestRate.value)) || (interestRate.value.indexOf(" ") != -1) || 
								(interestRate.value.length <= 0)) {
				alert("Incorrect format. Please enter a valid interest rate");
			 return false;
		} else if (isNaN(maxLoanAmount.value) || (maxLoanAmount.value.indexOf(" ") != -1) ||
											(maxLoanAmount.value.length <= 0)) {
			 alert("Please enter the maximum loan amount");
			 return false;
		}
	}
</script>
</head>

<body background="images/snowflakes_on_light_purple.jpg">
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
								<th><a href="/Sprint-1/SearchLoanOffers.jsp?isHome=true"> <b> SEARCH BANKS </b></a></th>
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
								<th><a href="/Sprint-1/postLoanOffers.jsp"> <b> POSTS </b></a></th>
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
					<td>Post Name</td>
					<td colspan=3><input type="text" name="postName" id="postNameID"
						value="${requestScope.bankName}"></td>
				</tr>

				<tr>
					<td>University name</td>
					<td colspan=3><select name="universityName" id="universityNameID">
							<option value="1">All Universities</option>
							<option value="50000">The University of North Carolina at Chapel Hill</option>
							<option value="50001">The University of North Carolina at Charlotte</option>
							<option value="50002">North Carolina State University</option>
					</select></td>
				</tr>

				<tr>
					<td>Loan Features</td>
					<td colspan=3><textarea rows="4" cols="50" name="loanFeatures"
							id="loanFeaturesID"></textarea></td>
				</tr>

				<tr>
					<td>Mandatory Documents</td>
					<td colspan=3><textarea rows="4" cols="50" name="mandtoryDocs"
							id="mandtoryDocsID"></textarea></td>
				</tr>

				<tr>
					<td>Interest rate(in numbers)</td>
					<td><input type="text" name="interestRate" id="interestRateID"
						value="${requestScope.interestRate}"></td>
				</tr>
				
				<tr>
					<td>Duration(in months)</td>
					<td><input type="text" name="maxDuration" id="maxDurationID" placeholder="Max"
						value="${requestScope.maxDuration}"></td>
				</tr>

				<tr>
					<td>Loan amount(in numbers)</td>
					<td><input type="text" name="minLoanAmount" placeholder="Min"
						id="minLoanAmountID" value="${requestScope.minLoanAmount}"></td>
					<td>to</td>
					<td><input type="text" name="maxLoanAmount" id="maxLoanAmountID" placeholder="Max"
						value="${requestScope.maxLoanAmount}"></td>
				</tr>

				<tr>
					<td>Processing Fee(% of loan amount)</td>
					<td><input type="text" name="processingFee" id="processingFeeID"
						value="${requestScope.processingFee}"></td>
				</tr>
				
				<tr>
					<td>Pre-payments</td>
					<td>
					<input type="radio" name="prePayments" id="prePaymentsID" value="true" checked>Yes
					</td>
					<td>
					<input type="radio" name="prePayments" id="prePaymentsID" value="false">No
					</td>
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