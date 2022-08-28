
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="toan.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Your Cart Include</h1>
        <c:if test="${not empty sessionScope.CART}">
            <c:if test="${sessionScope.CART != null && not empty sessionScope.CART.getItems().isEmpty()}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Title</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <form action="MainController" method="POST">
                        <c:forEach var="items" items="${sessionScope.CART.getItems()}" varStatus="counter">
                            <tr>
                                <th>
                                    ${counter.count}
                                </th>

                                <th>
                                    ${items.key}
                                </th>

                                <th>
                                    ${items.value}
                                </th>

                                <th>
                                    <input type="checkbox" name="chKBook" value="${items.key}" />
                                </th>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>
                                <input type="submit" value="Remove" name="btAction" />
                            </td>
                        </tr>
                    </form>
                </tbody>
            </table>
        </c:if>
    </c:if>
    <c:if test="${sessionScope.CART == null}">
        <h1>No Items</h1>
    </c:if>
    <a href="bookStore.html">Add More Item To Cart</a>
</body>
</html>
