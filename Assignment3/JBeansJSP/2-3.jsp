<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>

    <h2>Error: Invalid Input Range</h2>
    <p>The provided value does not fall within the defined ranges (less than 10, or between 11 and 98).</p>
    <p>Value entered: <%= request.getParameter("operation") %></p>

    <br>
    <a href="input.html">Back to Form</a>

</body>
</html>