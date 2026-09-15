package com.spring.assignment.task6;

public class Student {
    private String studentId;
    private String studentName;
    private Test studentTest;

    public Student() {}
    public Student(String studentId, String studentName, Test studentTest) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentTest = studentTest;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public Test getStudentTest() { return studentTest; }
    public void setStudentTest(Test studentTest) { this.studentTest = studentTest; }

    public void display() {
        System.out.println("Student ID: " + studentId + ", Name: " + studentName +
                ", Test: " + studentTest.getTestTitle() + " (" + studentTest.getTestId() + "), Marks: " + studentTest.getTestMarks());
    }
}