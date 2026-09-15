package com.wipro.springboot;

import com.wipro.springboot.task2.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Runner to automatically test and display Task 1 & Task 2 on startup
    @Bean
    public CommandLineRunner runner(Laptop laptop) {
        return args -> {
            System.out.println("\n==========================================");
            System.out.println("TASK 1: Spring Boot Application Message");
            System.out.println("Hello ");
            System.out.println("==========================================");

            System.out.println("\n==========================================");
            System.out.println("TASK 2: Dependency Injection & @Autowired");
            laptop.displayDetails();
            System.out.println("==========================================\n");
        };
    }
}