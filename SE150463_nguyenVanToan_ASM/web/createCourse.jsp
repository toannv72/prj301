<%-- 
    Document   : createCourse
    Created on : Aug 18, 2022, 10:43:36 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create course Page</title>
    </head>
    <body>
        <h1>Create course page</h1>
        <form action="MainController" method="POST">
            <c:set var="err" value="${requestScope.ERRORS}" />
            <c:if test="${not empty err.tuitionFeeErr}">
                <font color="red">${err.tuitionFeeErr}</font>
            </c:if>
        </form>
    </body>
</html>
