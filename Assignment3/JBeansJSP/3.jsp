<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="EmpBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Records</title>
</head>
<body>

    <h2>Employee Records</h2>

    <%
        String msg = (String) request.getAttribute("resultMessage");
        if (msg != null && !msg.isEmpty()) {
    %>
        <p><strong>Status:</strong> <%= msg %></p>
    <%
        }
    %>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Designation</th>
        </tr>
        <%
            List<EmpBean> list = (List<EmpBean>) request.getAttribute("empList");
            if (list != null && !list.isEmpty()) {
                for (EmpBean e : list) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getName() %></td>
            <td><%= e.getDesignation() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No records found.</td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="index.html">Back to Form</a>

</body>
</html>