<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Salary Statement</title>
</head>
<body>

    <!-- 1. Instantiate or locate the bean -->
    <jsp:useBean id="empSalary" class="EmployeeSalaryBean" scope="request" />

    <!-- 2. Automatically populate bean properties from matching request parameters -->
    <jsp:setProperty name="empSalary" property="*" />

    <h2>Employee Salary Statement</h2>

    <table border="1">
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>Employee ID</td>
            <td><jsp:getProperty name="empSalary" property="empId" /></td>
        </tr>
        <tr>
            <td>Employee Name</td>
            <td><jsp:getProperty name="empSalary" property="empName" /></td>
        </tr>
        <tr>
            <td>Basic Salary</td>
            <td><jsp:getProperty name="empSalary" property="basicSalary" /></td>
        </tr>
        <tr>
            <td>HRA</td>
            <td><jsp:getProperty name="empSalary" property="hra" /></td>
        </tr>
        <tr>
            <td>DA</td>
            <td><jsp:getProperty name="empSalary" property="da" /></td>
        </tr>
        <tr>
            <td>Deductions</td>
            <td><jsp:getProperty name="empSalary" property="deductions" /></td>
        </tr>
        <tr>
            <td><strong>Gross Salary</strong></td>
            <td><strong><%= empSalary.getGrossSalary() %></strong></td>
        </tr>
        <tr>
            <td><strong>Net Salary</strong></td>
            <td><strong><%= empSalary.getNetSalary() %></strong></td>
        </tr>
    </table>

    <br>
    <a href="salaryForm.html">Back to Form</a>

</body>
</html>