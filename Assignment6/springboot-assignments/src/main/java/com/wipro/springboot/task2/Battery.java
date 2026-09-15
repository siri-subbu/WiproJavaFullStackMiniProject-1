package com.wipro.springboot.task2;

import org.springframework.stereotype.Component;

@Component
public class Battery {
    private String capacity = "5000 mAh";

    public String getCapacity() {
        return capacity;
    }
}