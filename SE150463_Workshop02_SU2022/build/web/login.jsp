
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername" value=""/> <br>
            Password: <input type="password" name="txtPassword" value=""/> <br>
            <input type="submit" value="Login" name="btAction"/>
              <input type="reset" value="Reset"/>
        </form>
        <a href="bookStore.html">Shopping Book</a>
        <br>
        <a href="createNewAccount.jsp">Create new account</a>
        <font color='red'>
        <br>
        ${requestScope.ERROR}
        </font>
    </body>
</html>
