package com.hibernate.assignment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MULTI_CAR_OWNER")
public class MultiCarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;

    private String ownerName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private List<CarDetails> cars = new ArrayList<>();

    public MultiCarOwner() {}
    public MultiCarOwner(String ownerName, List<CarDetails> cars) {
        this.ownerName = ownerName;
        this.cars = cars;
    }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public List<CarDetails> getCars() { return cars; }
    public void setCars(List<CarDetails> cars) { this.cars = cars; }
}