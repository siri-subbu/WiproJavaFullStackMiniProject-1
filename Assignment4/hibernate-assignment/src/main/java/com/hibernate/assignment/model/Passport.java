package com.hibernate.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "PASSPORT")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;

    private String passportNumber;

    public Passport() {}
    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getPassportId() { return passportId; }
    public void setPassportId(int passportId) { this.passportId = passportId; }
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
}