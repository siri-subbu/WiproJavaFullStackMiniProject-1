<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page 2</title>
</head>
<body>

    <h2>Welcome to Page 2</h2>
    <p>The input value is between 10 and 99 (greater than 10 and less than 99).</p>
    <p>Value received: <%= request.getAttribute("inputValue") %></p>

    <br>
    <a href="input.html">Back to Form</a>

</body>
</html>