<%-- 
    Document   : viewCourse
    Created on : Aug 18, 2022, 5:06:44 PM
    Author     : Admin
--%>

<%@page import="java.util.Map"%>
<%@page import="ass.course.CourseObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View course Page</title>
    </head>
    <body>
        <%
            if (session != null) {
                CourseObj cart = (CourseObj) session.getAttribute("COURSE");
                if (cart != null) {
                    if (cart.getItems() != null) {
        %>
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
            <form action="MainController">
                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 0;
                    for (Map.Entry<String, Integer> item : items.entrySet()) {
                %>
                <tr>
                    <td><%=++count%></td>
                    <td><%=item.getKey()%></td>
                    <td><input type="text" name="txtQuantity" value="<%=item.getValue()%>"/></td>
                    <td><input type="checkbox" name="chkItem" value="<%=item.getKey()%>"></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="3">
                        <a href="chooseCourse.html">Add more items to cart</a>
                    </td> 
                    <td><input type="submit" value="Remove selected items" name="btAction"></td>
                </tr>
            </form>
        </tbody>
    </table>
    <%
                    return;
                }
            }
        }
    %>
    </body>
</html>
