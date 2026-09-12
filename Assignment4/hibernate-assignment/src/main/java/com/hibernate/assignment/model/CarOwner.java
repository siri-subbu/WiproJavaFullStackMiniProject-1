package com.hibernate.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "CAR_OWNER")
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;

    private String ownerName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_reg_no")
    private CarDetails car;

    public CarOwner() {}
    public CarOwner(String ownerName, CarDetails car) {
        this.ownerName = ownerName;
        this.car = car;
    }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public CarDetails getCar() { return car; }
    public void setCar(CarDetails car) { this.car = car; }
}