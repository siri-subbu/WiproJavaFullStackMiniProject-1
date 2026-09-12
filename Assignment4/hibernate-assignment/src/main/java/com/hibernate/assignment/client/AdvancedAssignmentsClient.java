package com.hibernate.assignment.client;

import com.hibernate.assignment.model.*;
import com.hibernate.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

public class AdvancedAssignmentsClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // TASK 8: Insert Car Records
        CarDetails c1 = new CarDetails("KL-07 AB 123", "Polo", "White", "Volkswagen");
        CarDetails c2 = new CarDetails("KL-07 AB 234", "Vento", "Black", "Volkswagen");
        CarDetails c3 = new CarDetails("KL-07 AC 345", "Corolla", "Silver", "Toyota");
        session.saveOrUpdate(c1);
        session.saveOrUpdate(c2);
        session.saveOrUpdate(c3);

        // TASK 15: One-to-One CarOwner
        CarDetails carOwnerObj = new CarDetails("KL-08 X 999", "Golf", "Red", "Volkswagen");
        session.saveOrUpdate(carOwnerObj);
        session.save(new CarOwner("Owner 1", carOwnerObj));

        // TASK 16: One-to-Many MultiCarOwner
        List<CarDetails> carList = new ArrayList<>();
        CarDetails extraCar = new CarDetails("KL-09 Y 888", "Innova", "Grey", "Toyota");
        session.saveOrUpdate(extraCar);
        carList.add(extraCar);
        session.save(new MultiCarOwner("Owner 2", carList));

        // TASK 17: Map Collection Continent
        Map<String, String> countryMap = new HashMap<>();
        countryMap.put("India", "New Delhi");
        countryMap.put("Germany", "Berlin");
        session.save(new Continent("Eurasia", countryMap));

        // TASK 18 & 19: Employee & Passport Cascade
        Passport pass = new Passport("P12398745");
        EmployeeCascade empCascade = new EmployeeCascade("David", pass);
        session.save(empCascade);

        // TASK 20: Component Mapping
        Address addr = new Address("Marine Drive", "Kochi", "Kerala");
        session.save(new EmployeeWithAddress("Anil", addr));

        tx.commit();

        // TASK 9: HQL All Cars
        System.out.println("\n--- TASK 9: All Cars (HQL) ---");
        List<CarDetails> cars = session.createQuery("from CarDetails", CarDetails.class).list();
        cars.forEach(c -> System.out.println(c.getRegNo() + " | " + c.getModel() + " | " + c.getColor() + " | " + c.getManufacturer()));

        // TASK 10: RegNo and Manufacturer Projections
        System.out.println("\n--- TASK 10: RegNo & Manufacturer Projections ---");
        List<Object[]> rows = session.createQuery("select c.regNo, c.manufacturer from CarDetails c", Object[].class).list();
        for (Object[] r : rows) {
            System.out.println(r[0] + " | " + r[1]);
        }

        // TASK 11: Query with Named Parameter
        System.out.println("\n--- TASK 11: Search by RegNo ---");
        Query<CarDetails> q = session.createQuery("from CarDetails c where c.regNo = :regLabel", CarDetails.class);
        q.setParameter("regLabel", "KL-07 AB 123");
        CarDetails found = q.uniqueResult();
        if (found != null) {
            System.out.println("Found: " + found.getModel() + " by " + found.getManufacturer());
        }

        // TASK 12: Manufacturers starting with 'V'
        System.out.println("\n--- TASK 12: Manufacturers Starting With 'V' ---");
        List<String> manufacturers = session.createQuery("select distinct c.manufacturer from CarDetails c where c.manufacturer like 'V%'", String.class).list();
        manufacturers.forEach(System.out::println);

        // TASK 13: Criteria Query Filter by Color
        System.out.println("\n--- TASK 13: Criteria Query (Color = 'White') ---");
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CarDetails> cq = cb.createQuery(CarDetails.class);
        Root<CarDetails> root = cq.from(CarDetails.class);
        cq.select(root).where(cb.equal(root.get("color"), "White"));
        List<CarDetails> whiteCars = session.createQuery(cq).getResultList();
        whiteCars.forEach(c -> System.out.println(c.getRegNo() + " - " + c.getModel()));

        // TASK 14: Criteria Query Total Count
        System.out.println("\n--- TASK 14: Criteria Query (Count) ---");
        CriteriaQuery<Long> countCq = cb.createQuery(Long.class);
        Root<CarDetails> countRoot = countCq.from(CarDetails.class);
        countCq.select(cb.count(countRoot.get("regNo")));
        System.out.println("Total Cars: " + session.createQuery(countCq).getSingleResult());

        // TASK 19: Cascading Delete
        System.out.println("\n--- TASK 19: Cascading Delete Verification ---");
        tx = session.beginTransaction();
        session.delete(empCascade);
        tx.commit();
        System.out.println("EmployeeCascade and Passport deleted via cascade.");

        session.close();
        HibernateUtil.shutdown();
    }
}