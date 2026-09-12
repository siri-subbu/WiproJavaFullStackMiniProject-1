package com.hibernate.assignment.model;

public class EmployeeIncrement {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public EmployeeIncrement() {}
    public EmployeeIncrement(String name, String designation, double salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}