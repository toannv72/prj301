
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="toan.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <font color="red">
        <%
            String username = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String temp = cookie.getName();
                    if (!temp.equals("JSESSIONID")) {
                            username = temp;

                    }
                }
        %>
        Welcome <%= username%>
        <%
            }
        %>
        </font>
        <h1>Search</h1>
        <form action="MainController">
            Search name: <input type="text" name="txtSearchValue" value="${param.txtSearchValue}"/>
            <input type="submit" name="btAction" value="Search"/>
        </form>
            <a href="login.jsp">login</a>
        <c:if test="${not empty requestScope.SEARCHRESULT}" >
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Last name</th>
                        <th>Role</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="result" items="${requestScope.SEARCHRESULT}" varStatus="counter">
                    <form action="MainController">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${result.getUsername()}
                                <input type="hidden" name="txtUsername" value="${result.getUsername()}" />
                            </td>
                            <td>
                                <input type="text" name="txtPassword" value="${result.getPassword()}" /> 
                            </td>
                            <td>
                                <input type="text" name="txtLastname" value="${result.getLastname()}" />
                            </td>
                            <td>
                                <input type="checkbox" name="chkAdmin" value="ADMIN"  <c:if test="${result.isRole() == true }">checked="checked"</c:if> />
                                </td>
                                <td>
                                <c:url var="DeleteLink" value="MainController">
                                    <c:param name="btAction" value="delete"/>
                                    <c:param name="pk" value="${result.getUsername()}"/>
                                    <c:param name="lastSearchValue" value="${param.txtSearchValue}"/>

                                </c:url>
                                <a href="${DeleteLink}">Delete</a>
                            </td>
                            <td>
                                <input type="submit" value="Update" name="btAction" />
                                <input type="hidden" name="lastSearchValue" value="${param.txtSearchValue}" />
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
