<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>
</head>
<body background="images/snowflakes_on_light_purple.gif">
	<form action="LoginContoller" method="post">
		<center>
			<div>
				<fieldset style="width: 300px">
					<legend> Login to your university your bank </legend>
					<div>
						<c:if test="${requestScope.message != null}">
							<c:out value="${requestScope.message}"></c:out>
						</c:if>
					</div>
					<table>
						<tr>
							<td width="%50">User Name</td>
							<td width="%50"><input type="text" name="userName" required="required" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="userPassword" required="required" /></td>
						</tr>
					</table>
						<tr>
							<td>
								<input type="submit" value="Sign In"/>
							</td>
							<td>
								<input type="reset" value="Reset"/>
							</td>
						</tr>
					<table>
					</table>
				</fieldset>
			</div>
			<div>
				Do not have an account yet? <br> <a
					href="/Sprint-1/StudentRegistration.jsp">Click here to Sign Up as Student</a>
				<br> <a href="/Sprint-1/BankerRegistration.jsp">Click here to Sign
					Up as Banker</a>
			</div>
		</center>
	</form>
</body>
</html>
