package com.hibernate.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_CASCADE")
public class EmployeeCascade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    public EmployeeCascade() {}
    public EmployeeCascade(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) { this.passport = passport; }
}