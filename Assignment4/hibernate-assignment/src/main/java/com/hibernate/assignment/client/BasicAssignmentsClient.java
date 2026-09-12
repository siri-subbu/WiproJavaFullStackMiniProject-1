package com.hibernate.assignment.client;

import com.hibernate.assignment.model.*;
import com.hibernate.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;

public class BasicAssignmentsClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // TASK 1: EMP Table Record
        Emp emp = new Emp(9001, "SCOTT_DEV", "ANALYST", 4500.0);
        session.saveOrUpdate(emp);

        // TASK 2 & 5: Flowers
        session.saveOrUpdate(new Flower("1", "Rose", "Red", 10.0));
        session.saveOrUpdate(new Flower("2", "Carnation", "White", 15.0));

        // TASK 3: 5 Auto-Incremented Employees
        for (int i = 1; i <= 5; i++) {
            session.save(new EmployeeIncrement("Dev_" + i, "Engineer", 45000.0 + (i * 3000)));
        }

        // TASK 4: 5 Products from Sequence
        for (int i = 1; i <= 5; i++) {
            session.save(new Product("Item_" + i, 150.0 * i));
        }

        tx.commit();
        session.close();

        // TASK 5: Retrieve Flower 2
        session = HibernateUtil.getSessionFactory().openSession();
        Flower f2 = session.get(Flower.class, "2");
        if (f2 != null) {
            System.out.println("Retrieved Flower 2: " + f2.getFlowerName() + " | Color: " + f2.getColor() + " | Price: " + f2.getPrice());
        }
        session.close();

        // TASK 7: Interactive Price Update
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Flower ID to update price (e.g. 2): ");
        String updateId = sc.nextLine().trim();
        System.out.print("Enter New Price: ");
        double newPrice = sc.nextDouble();

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        Flower toUpdate = session.get(Flower.class, updateId);
        if (toUpdate != null) {
            toUpdate.setPrice(newPrice);
            session.update(toUpdate);
            tx.commit();
            System.out.println("Updated -> ID: " + toUpdate.getFlowerId() + ", New Price: " + toUpdate.getPrice());
        } else {
            System.err.println("Flower ID " + updateId + " does not exist.");
            tx.rollback();
        }
        session.close();
        

        // TASK 6: Interactive Flower Delete
        System.out.print("Enter Flower ID to delete (e.g. 1): ");
        sc.nextLine(); // clear input buffer
        String delId = sc.nextLine().trim();

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        Flower toDelete = session.get(Flower.class, delId);
        if (toDelete != null) {
            session.delete(toDelete);
            tx.commit();
            System.out.println("Flower ID " + delId + " deleted successfully.");
        } else {
            System.err.println("Error: Flower ID " + delId + " does not exist.");
            tx.rollback();
        }
        session.close();
        sc.close();
        HibernateUtil.shutdown();
    }
}