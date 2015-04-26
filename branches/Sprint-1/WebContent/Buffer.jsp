<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<title>Insert title here</title>

		<script language="javascript">
    	  function doSubmit(){
        	  //document.getElementById("butClick").click();
    		  document.forms[0].submit();
      	}
	  	</script>
	</head>
	<body  background="images/snowflakes_on_light_purple.jpg" onLoad= "doSubmit()">
	<form action="GetWishListDataController" method="post">
		<!-- <input type="submit" id="butClick" name="butClick" value="click me">  -->   
	</form>
</body>
</html>