<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Loan Offers</title>
</head>
<body>
	<form action="SearchLoanOfferController" method="post">
		<center>
			<div>
				<table>
					<tr>
						<td>University Name :</td>
						<td><input type="text" name="uName"
							value="${requestScope.uName}"></td>
						
						<td>Country:</td>
						<td><input type="text" name="lCountry"
							value="${requestScope.lCountry}"></td>
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
						<tr align="center" bgcolor="red">
							<th align="center" width="10%">Bank Name</th>
							<th align="center" width="10%">Loan Officer</th>
							<th align="center" width="10%">Telephone</th>
							<th align="center" width="10%">Email</th>
							<th align="center" width="10%">Interest rate</th>
							<th align="center" width="10%">Loan amount</th>
							<th align="center" width="25%">Loan details</th>
						</tr>
						<c:forEach items="${requestScope.loaList}" var="loa">
							<tr>
								<td><c:out value="${loa.bankName}"></c:out></td>
								<td><c:out value="${loa.contactPerson}"></c:out></td>
								<td><c:out value="${loa.contactNum}"></c:out></td>
								<td><c:out value="${loa.contactEmail}"></c:out></td>
								<td><c:out value="${loa.intrestRate}"></c:out></td>
								<td><c:out value="${loa.maxLoanAmount}"></c:out></td>
								<td><c:out value="${loa.loanDescription}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</center>
	</form>
</body>
</html>