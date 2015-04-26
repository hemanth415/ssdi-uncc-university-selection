<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banker Registration</title>
<script>
	function validateForm() {
		var firstName = document.getElementById("firstNameID");
		var lastName = document.getElementById("lastNameID");
		var rePassWord = document.getElementById("rePassWordID");
		var passWord = document.getElementById("passWordID");
		var bankerEmail = document.getElementById("bankerEmailID");
		var bankerContactNum = document.getElementById("bankerContactNumID");
		var bankName = document.getElementById("bankNameID");
		var bankAddress = document.getElementById("bankAddressID");
		var bankZipCode = document.getElementById("bankZipCodeID");
		var bankContactNum = document.getElementById("bankContactNumID");
		var bankEmail = document.getElementById("bankEmailID");

		if (firstName.value.length <= 0) {
			alert("Please enter your first name");
			return false;
		} else if (lastName.value.length <= 0) {
			alert("Please enter your last name");
			return false;
		} else if (rePassWord.value.length <= 0) {
			alert("Please enter a valid password");
			return false;
		} else if (passWord.value.length <= 0) {
			alert("Please enter a valid password");
			return false;
		} else if (bankerEmail.value.length <= 0) {
			alert("Please enter your email");
			return false;
		} else if ((isNaN(bankerContactNum.value))
				|| (bankerContactNum.value.indexOf(" ") != -1)) {
			alert("Please enter a valid phoneNumber");
			return false;
		} else if (bankName.value.length <= 0) {
			alert("Please enter your Bank's name");
			return false;
		} else if (bankAddress.value.length <= 0) {
			alert("Please enter the Address of your bank");
			return false;
		} else if (isNaN(bankZipCode.value)
				|| (bankZipCode.value.indexOf(" ") != -1)) {
			alert("Please enter a valid Zip code");
			return false;
		} else if (bankEmail.value.length <= 0) {
			alert("Please enter the email of your Bank");
			return false;
		} else if (isNaN(bankContactNum.value)
				|| (bankContactNum.value.indexOf(" ") != -1)) {
			alert("Please enter a valid phone number of your Bank");
			return false;
		} else if (passWord.value != rePassWord.value) {
			alert("Passwords are Matching!!");
			return false;
		}
	}
	function checkPass() {
		var password = document.getElementById('passWordID');
		var rePassword = document.getElementById('rePassWordID');
		var message = document.getElementById('confirmMessage');
		if (password.value == rePassword.value) {
			message.innerHTML = "Passwords are Matching!"
		} else {
			message.innerHTML = "Passwords are not Matching!"
		}
	}
</script>
</head>
<body background="images/snowflakes_on_light_purple.jpg">
	<form action="BankerRegistrationController"
		onsubmit="return validateForm();" method="post">
		<h2 align="center">Banker Registration</h2>
		<h4 align="center">
			<span id="confirmMessage"></span>
		</h4>
		<br>
		<div>
			<c:if test="${requestScope.message != null}">
				<c:out value="${requestScope.message}"></c:out>
			</c:if>
		</div>
		<table align="center">
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName" id="firstNameID"
					value="${requestScope.firstName}"></td>
			</tr>

			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName" id="lastNameID"
					value="${requestScope.lastName}"></td>
			</tr>

			<tr>
				<td>User Name / Email :</td>
				<td><input type="email" name="bankerEmail" id="bankerEmailID"
					value="${requestScope.bankerEmailId}"></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="passWord" id="passWordID"
					value="${requestScope.passWord}"></td>
			</tr>

			<tr>
				<td>Re-Enter Password :</td>
				<td><input type="password" name="rePassWord" id="rePassWordID"
					value="${requestScope.RePassWord}"
					onchange="checkPass(); return false;"></td>
			</tr>

			<tr>
				<td>Contact :</td>
				<td><input type="text" name="bankerContactNum"
					id="bankerContactNumID" value="${requestScope.bankerContactNum}"></td>
			</tr>

			<tr>
				<td>Bank Name :</td>
				<td><input type="text" name="bankName" id="bankNameID"
					value="${requestScope.bankName}"></td>
			</tr>

			<tr>
				<td>Bank Address :</td>
				<td><input type="text" name="bankAddress" id="bankAddressID"
					value="${requestScope.bankAddress}"></td>
			</tr>

			<tr>
				<td>Zip Code:</td>
				<td><input type="text" name="bankZipCode" id="bankZipCodeID"
					value="${requestScope.bankZipCode}"></td>
			</tr>

			<tr>
				<td>Bank Contact:</td>
				<td><input type="text" name="bankContactNum"
					id="bankContactNumID" value="${requestScope.bankContactNum}"></td>
			</tr>

			<tr>
				<td>Bank email :</td>
				<td><input type="text" name="bankEmail" id="bankEmailID"
					value="${requestScope.bankEmailId}"></td>
			</tr>
		</table>
		<br> <br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Register" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>