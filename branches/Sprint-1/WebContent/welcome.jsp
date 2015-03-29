<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
   <head>  
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
       <title>Welcome</title>  
   </head>  
 <body background="images/snowflakes_on_light_purple.gif">
          <h1>Your University Your Bank</h1>
           <h4 align="right">  
                						Hello,<%=session.getAttribute("user")%>
                						<br> 
                						<a href="LOGOUTlink">
										<b>
														LOGOUT
										</b>
										</a>
	       </h4>
	<br>
	<a href="/Sprint-1/universitySearch.jsp">
	   <b>
     		SEARCH UNIVERSITIES
	   </b>
	</a>
	<br>
	<a href="edityourprofilelink" >
	   <b>
	          PROFILE
	   </b>
	</a>
	<br>
	<a href="LINK TO LIST OF BANKERS PROVIDING LOANS" >
	  <b>
	          EDUCATION LOANS
	  </b>
	</a>
 </body>  
</html>