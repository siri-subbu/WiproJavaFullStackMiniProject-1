<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page 1</title>
</head>
<body>

    <h2>Welcome to Page 1</h2>
    <p>The input value is strictly less than 10.</p>
    <p>Value received: <%= request.getAttribute("inputValue") %></p>

    <br>
    <a href="input.html">Back to Form</a>

</body>
</html>