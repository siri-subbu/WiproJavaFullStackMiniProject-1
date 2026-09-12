<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Processing Request</title>
</head>
<body>

    <!-- Instantiate Bean and populate fields automatically from request parameters -->
    <jsp:useBean id="emp" class="EmpBean" scope="request" />
    <jsp:setProperty name="emp" property="*" />

    <!-- Pass action along with bean to the Servlet -->
    <%
        request.setAttribute("empBean", emp);
        request.setAttribute("action", request.getParameter("action"));
    %>

    <jsp:forward page="/EmpServlet" />

</body>
</html>