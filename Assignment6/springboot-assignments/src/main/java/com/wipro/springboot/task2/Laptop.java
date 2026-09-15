package com.wipro.springboot.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private final HardDisk hardDisk;
    private final Battery battery;

    @Autowired
    public Laptop(HardDisk hardDisk, Battery battery) {
        this.hardDisk = hardDisk;
        this.battery = battery;
    }

    public void displayDetails() {
        System.out.println("Laptop assembled successfully with:");
        System.out.println("- Hard Disk: " + hardDisk.getCapacity());
        System.out.println("- Battery:   " + battery.getCapacity());
    }
}