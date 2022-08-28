
<%@page import="toan.registration.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="MainController" method="POST">
            Username(*) <input type="text" name="txtUsername" 
                               value="${param.txtUsername}" />(5 - 20 Chars)</br>
            <font color="red">
            ${requestScope.INSERTERROR.getUsernameLengthError()}</br>
            </font>
            Password(*) <input type="password" name="txtPassword" value="" />(6 - 20 Chars)</br>
            <font color="red">
            ${requestScope.INSERTERROR.getPasswordLengthError()}</br>
            </font>
            Confirm(*) <input type="password" name="txtConfirm" value="" /></br>
            <font color="red">
            ${requestScope.INSERTERROR.getConfirmNotMatch()}</br>
            </font>
            Full name <input type="text" name="txtFullname" value="${param.txtFullname}" />(2 - 50 Chars)</br>
            <font color="red">
            ${requestScope.INSERTERROR.getFullnameLengthError()}</br>
            </font>
            <input type="submit" name="btAction" value="Create New Account" />
            <input type="reset" value="Reset" />
        </form>
        <font color="red">
        ${requestScope.INSERTERROR.getUsernameIsExisted()}</br>
        </font>
        
        <a href="login.jsp">login</a>
    </body>
</html>
