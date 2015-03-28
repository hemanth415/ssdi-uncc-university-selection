<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
   <head>  
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
       <title>Welcome <%=session.getAttribute("name")%></title>  
   </head>  
 <body background="images/snowflakes_on_light_purple.gif">
          <h1>Your University Your Bank</h1>

    
           <h4 align="right">  
                              Hello,  
                                        <%=session.getAttribute("name")%> <a href="LOGOUTlink">
																			<b>
																					LOGOUT
																			</b>
																		</a>
	       </h4>
		   
	
	<a href="/Sprint-1/universitySearch.jsp">
	   <b>
     <h2>SEARCH UNIVERSITIES</h2>
	   </b>
	</a>
	<a href="edityourprofilelink" >
	   <b>
	      <h2>
	          PROFILE
	      </h2>
	   </b>
	</a>
		<a href="LINK TO LIST OF BANKERS PROVIDING LOANS" >
	     <b>
	       <h2>
	          EDUCATION LOANS
	       </h2>
	     </b>
	    </a>
	
		
 </body>  
</html>
 