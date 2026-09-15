<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Task 13: Student Records</title></head>
<body>
    <h2>All Students (From Oracle DB)</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Marks</th>
        </tr>
        <c:forEach var="s" items="${students}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.marks}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="student-form">Add Another Student</a> | <a href="./">Home</a>
</body>
</html>