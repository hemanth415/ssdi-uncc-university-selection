<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Banker Registration Page</title>
	<script>
		function validateForm() {
    		var firstName = document.getElementById("firstNameID");
    		var lastName = document.getElementById("lastNameID");
    		var userName = document.getElementById("userNameID");
    		var passWord = document.getElementById("passWordID");
    		var bankerEmail = document.getElementById("bankerEmailID");
    		var bankerContactNum = document.getElementById("bankerContactNumID");
    		var bankName = document.getElementById("bankNameID");
    		var bankAddress = document.getElementById("bankAddressID");
    		var bankZipCode = document.getElementById("bankZipCodeID");
    		var bankContactNum = document.getElementById("bankContactNumID");
    		var bankEmail = document.getElementById("bankEmailID");
    		
	    	if (firstName.value.length <=0) 
	    	{
    	    	alert("Please enter your first name");
        		return false;
    		} 
	    	else if (lastName.value.length <=0) 
	    	{
    	    	alert("Please enter your last name");
        		return false;
    		} 
	    	else if (userName.value.length <=0) 
	    	{
    	    	alert("Please enter a valid first name");
        		return false;
    		}
	    	else if (passWord.value.length <=0) 
	    	{
    	    	alert("Please enter a valid password");
        		return false;
    		}
	    	else if (bankerEmail.value.length <=0) 
	    	{
    	    	alert("Please enter your email");
        		return false;
    		}
	    	else if ((isNaN(bankerContactNum.value)) || (bankerContactNum.value.indexOf(" ")!=-1)) 
	    	{
    	    	alert("Please enter a valid phoneNumber");
        		return false;
    		}
	    	else if (bankName.value.length <=0) 
	    	{
    	    	alert("Please enter your Bank's name");
        		return false;
    		} else if (bankAddress.value.length <=0) 
    		{
    	    	alert("Please enter the Address of your bank");
        		return false;
    		}
    		else if (isNaN(bankZipCode.value) || (bankZipCode.value.indexOf(" ")!=-1)) 
    		{
    	    	alert("Please enter a valid Zip code");
        		return false;
    		} 
    		else if (bankEmail.value.length <=0) 
    		{
    	    	alert("Please enter the email of your Bank");
        		return false;
    		} 
    		else if (isNaN(bankContactNum.value) || (bankContactNum.value.indexOf(" ")!=-1)) 
    		{
    	    	alert("Please enter a valid phone number of your Bank");
        		return false;
    		} 
		}
</script>
</head>
<body>
	<form action="BankerRegistrationController"  onsubmit="return validateForm();" method="post">
	<h2 align="center">Banker Registration Page</h2><br/>
	
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
			<td>User Name :</td>
			<td><input type="text" name="userName" id="userNameID"
				value="${requestScope.userName}"></td>
		</tr>
		
		<tr> 
			<td>Password :</td>
			<td><input type="password" name="passWord" id="passWordID"
				value="${requestScope.passWord}"></td>
		</tr>
		
		<tr> 
			<td>Email :</td>
			<td><input type="text" name="bankerEmail" id="bankerEmailID"
				value="${requestScope.bankerEmailId}"></td>
		</tr>
		
		<tr> 
			<td>Contact :</td>
			<td><input type="text" name="bankerContactNum" id="bankerContactNumID"
				value="${requestScope.bankerContactNum}"></td>
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
			<td>Zip Code: </td>
			<td><input type="text" name="bankZipCode" id="bankZipCodeID"
				value="${requestScope.bankZipCode}"></td>
		</tr>
		
		<tr> 
			<td>Bank Contact: </td>
			<td><input type="text" name="bankContactNum" id="bankContactNumID"
				value="${requestScope.bankContactNum}"></td>
		</tr>
		
		<tr> 
			<td>Bank email :</td>
			<td><input type="text" name="bankEmail" id="bankEmailID"
				value="${requestScope.bankEmailId}"></td>
		</tr>
		<br/>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Register" /></td>
		</tr>
		
	</table>
	
	</form>
</body>
</html>