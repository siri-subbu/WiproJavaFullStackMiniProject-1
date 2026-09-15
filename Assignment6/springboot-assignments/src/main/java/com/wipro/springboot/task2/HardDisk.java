package com.wipro.springboot.task2;

import org.springframework.stereotype.Component;

@Component
public class HardDisk {
    private String capacity = "1TB SSD";

    public String getCapacity() {
        return capacity;
    }
}