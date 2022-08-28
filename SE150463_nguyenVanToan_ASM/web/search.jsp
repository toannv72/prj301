<%-- 
    Document   : search
    Created on : Aug 18, 2022, 6:15:25 AM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="ass.registration.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <style>
            body{
                background: beige
            }
        </style>
    </head>
    <body>
        <img src="https://www.daophatngaynay.com/vn/files/images/quy1-2010/11198281229096493_456282371.jpg" alt="Hoa hồng"/>
        <font color="red">
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String username = "";
                for (Cookie cookie : cookies) {
                    String temp = cookie.getName();
                    if (!temp.equals("JSESSIONID")) {
                        username = temp;
                    }
                }
        %>
        Welcome, <%=username%>
        <%
            }
        %>
        </font>
        <h1>TTK Piano Music</h1>
        <form action="MainController">
            Search <input type="text" name="txtSearch" value="" />
            <input type="submit" value="Search" name="btAction" />
            <input type="submit" value="Logout" name="btAction" />
        </form><br/>
        <%
            String search = request.getParameter("txtSearch");
            if (search != null) {
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCH_RESULT");
                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Tuition fee</th>
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Category</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                        String urlRewriting = "MainController?btAction=Delete&pk=" + dto.getName() + "&lastSearch=" + search;
                %>
            <form action="MainController">
                <tr>
                    <td><%=++count%></td>
                    <td><input type="text" name="txtName" value="<%=dto.getName()%>"/></td>
                    <td><input type="text" name="txtImage" value="<%=dto.getImage()%>"/></td>
                    <td><input type="text" name="txtDescription" value="<%=dto.getDescription()%>"/></td>
                    <td><input type="text" name="txtTuitionFee" value="<%=dto.getTuitionFee()%>"/></td>
                    <td><input type="text" name="txtStartDate" value="<%=dto.getStartDate()%>"/></td>
                    <td><input type="text" name="txtEndDate" value="<%=dto.getEndDate()%>"/></td>
                    <td><input type="text" name="txtCategory" value="<%=dto.getCategory()%>"/></td>
                    <td>
                        <a href="<%=urlRewriting%>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="lastSearch" value="<%=search%>" />
                        <input type="submit" name="btAction" value="Update" />
                    </td>
                </tr>

            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <h2>No record is matched!!!</h2>
    <%
            }
        }
    %>
</body>
</html>
