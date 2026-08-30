<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Factorial Table</title>
</head>
<body>

    <h2>Table of Numbers and Their Factorials</h2>

    <%! 
        // JSP Declaration to define factorial method
        long getFactorial(int n) {
            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    %>

    <table border="1">
        <tr>
            <th>Number (n)</th>
            <th>Factorial (n!)</th>
        </tr>
        <% 
            for (int i = 1; i <= 10; i++) { 
        %>
        <tr>
            <td><%= i %></td>
            <td><%= getFactorial(i) %></td>
        </tr>
        <% 
            } 
        %>
    </table>

</body>
</html>