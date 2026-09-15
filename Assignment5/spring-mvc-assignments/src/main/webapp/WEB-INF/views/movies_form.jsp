<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Task 10: Marks Form</title></head>
<body>
    <h2>Enter Subject Marks</h2>
    <form action="calculate-marks" method="post">
        Science Marks: <input type="number" name="science" required /><br/><br/>
        Maths Marks: <input type="number" name="maths" required /><br/><br/>
        English Marks: <input type="number" name="english" required /><br/><br/>
        <input type="submit" value="Calculate Total Marks" />
    </form>
</body>
</html>