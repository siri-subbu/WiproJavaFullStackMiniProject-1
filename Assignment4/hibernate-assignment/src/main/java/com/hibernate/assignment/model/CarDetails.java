package com.hibernate.assignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "CAR_DETAILS")
public class CarDetails {
    @Id
    @Column(name = "RegNo", length = 15)
    private String regNo;

    @Column(name = "Model", length = 20)
    private String model;

    @Column(name = "Color", length = 10)
    private String color;

    @Column(name = "Manufacturer", length = 20)
    private String manufacturer;

    public CarDetails() {}
    public CarDetails(String regNo, String model, String color, String manufacturer) {
        this.regNo = regNo;
        this.model = model;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
}