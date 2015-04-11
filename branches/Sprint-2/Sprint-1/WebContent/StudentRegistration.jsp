<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
<script>
	function validateForm() {
		var firstName = document.getElementById("firstNameID");
		var lastName = document.getElementById("lastNameID");
		var studentEmail = document.getElementById("emailID");
		var passWord = document.getElementById("passWordID");
		var rePassWord = document.getElementById("rePassWordID");
		var address = document.getElementById("addressID");
		var zipCode = document.getElementById("zipCodeID");
		var contactNum = document.getElementById("contactNumID");

		if (firstName.value.length <= 0) {
			alert("Please enter your first name");
			return false;
		} else if (lastName.value.length <= 0) {
			alert("Please enter your last name");
			return false;
		} else if (studentEmail.value.length <= 0) {
			alert("Please enter your email");
			return false;
		} else if (rePassWord.value.length <= 0) {
			alert("Please enter a valid password");
			return false;
		} else if (passWord.value.length <= 0) {
			alert("Please enter a valid password");
			return false;
		} else if (address.value.length <= 0) {
			alert("Please enter your Address");
			return false;
		} else if (isNaN(zipCode.value) || (zipCode.value.indexOf(" ") != -1)) {
			alert("Please enter a valid Zip code");
			return false;
		} else if ((isNaN(contactNum.value))
				|| (contactNum.value.indexOf(" ") != -1)) {
			alert("Please enter a valid phoneNumber");
			return false;
		}else if(passWord.value != rePassWord.value){
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
<body background="images/snowflakes_on_light_purple.gif">
	<form action="StudentRegistrationController"
		onsubmit="return validateForm();" method="post">
		<h2 align="center">Student Registration</h2>
		<h4 align="center">
			<span id="confirmMessage"></span>
		</h4>
		<br>
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
				<td><input type="email" name="email" id="emailID"
					value="${requestScope.email}"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="passWord" id="passWordID" 
					value="${requestScope.passWord}"></td>
			</tr>
			<tr>
				<td>Re-Enter Password :</td>
				<td><input type="password" name="rePassWord" id="rePassWordID"
					value="${requestScope.RePassWord}" onchange="checkPass(); return false;"></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" id="addressID"
					value="${requestScope.address}"></td>
			</tr>
			<tr>
				<td>Zip Code:</td>
				<td><input type="text" name="zipCode" id="zipCodeID"
					value="${requestScope.zipCode}"></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td><input type="text" name="contactNum" id="contactNumID"
					value="${requestScope.contactNum}"></td>
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