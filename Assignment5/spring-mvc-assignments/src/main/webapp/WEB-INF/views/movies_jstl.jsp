<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Task 11: Top Movies (JSTL)</title></head>
<body>
    <h2>Top 10 Movies / Series using JSTL &lt;c:forEach&gt;</h2>
    <ul>
        <c:forEach var="movie" items="${moviesList}">
            <li>${movie}</li>
        </c:forEach>
    </ul>
    <p><a href="./">Back to Home</a></p>
</body>
</html>