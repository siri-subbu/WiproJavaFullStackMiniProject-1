<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Task 12: Add Student</title></head>
<body>
    <h2>Register Student to Database</h2>
    <form action="save-student" method="post">
        Student ID: <input type="text" name="id" required /><br/><br/>
        Student Name: <input type="text" name="name" required /><br/><br/>
        Total Marks: <input type="number" name="marks" required /><br/><br/>
        <input type="submit" value="Save Student" />
    </form>
    <p><a href="view-students">View All Students</a></p>
</body>
</html>