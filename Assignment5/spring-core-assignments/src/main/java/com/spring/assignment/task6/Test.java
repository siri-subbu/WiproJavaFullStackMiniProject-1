package com.spring.assignment.task6;

public class Test {
    private String testId;
    private String testTitle;
    private int testMarks;

    public Test() {}
    public Test(String testId, String testTitle, int testMarks) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.testMarks = testMarks;
    }

    public String getTestId() { return testId; }
    public void setTestId(String testId) { this.testId = testId; }
    public String getTestTitle() { return testTitle; }
    public void setTestTitle(String testTitle) { this.testTitle = testTitle; }
    public int getTestMarks() { return testMarks; }
    public void setTestMarks(int testMarks) { this.testMarks = testMarks; }
}