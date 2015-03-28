<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Login Application</title>  
</head>  
<body background="images/snowflakes_on_light_purple.gif"> 
    <form action="loginServlet" method="post">  
        <fieldset style="width: 300px">  
            
            <legend> Login to  your university your bank </legend>  
                  <table>  
                <tr>  
                    <td>User ID</td>  
                    <td><input type="text" name="username" required="required" /></td>  
                </tr>  
                <tr>  
                    <td>Password</td>  
                    <td><input type="password" name="userpass" required="required" /></td>  
                </tr>  
                <tr>  
                    <td><input type="submit" value="Login" /></td>  
                </tr>  
                
            </table> 
             
        </fieldset>  
    </form>  
     <FORM METHOD="LINK" ACTION="page1.htm">
           <INPUT TYPE="submit" VALUE="create your student account ">
     </FORM>
     <FORM METHOD="LINK" ACTION="page1.htm">
           <INPUT TYPE="submit" VALUE="create your banker account">
     </FORM>
     
</body>  
</html>  