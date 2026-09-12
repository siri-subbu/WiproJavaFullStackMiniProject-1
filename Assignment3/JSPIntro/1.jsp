<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prime Numbers List</title>
</head>
<body>

    <%
        Integer limit = (Integer) request.getAttribute("inputLimit");
        ArrayList<Integer> primes = (ArrayList<Integer>) request.getAttribute("primes");
    %>

    <h2>Prime Numbers Less Than <%= limit %></h2>

    <%
        if (primes == null || primes.isEmpty()) {
    %>
        <p>No prime numbers found less than <%= limit %>.</p>
    <%
        } else {
    %>
        <table border="1">
            <tr>
                <th>S.No</th>
                <th>Prime Number</th>
            </tr>
            <%
                int count = 1;
                for (Integer prime : primes) {
            %>
            <tr>
                <td><%= count++ %></td>
                <td><%= prime %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <br>
    <a href="index.html">Back to Form</a>

</body>
</html>