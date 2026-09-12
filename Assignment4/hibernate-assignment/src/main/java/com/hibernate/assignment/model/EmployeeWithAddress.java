package com.hibernate.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_COMPONENT")
public class EmployeeWithAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String name;

    @Embedded
    private Address address;

    public EmployeeWithAddress() {}
    public EmployeeWithAddress(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}