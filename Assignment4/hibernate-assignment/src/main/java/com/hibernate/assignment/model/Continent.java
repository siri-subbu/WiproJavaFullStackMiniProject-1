package com.hibernate.assignment.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "CONTINENTS")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cname;

    @ElementCollection
    @CollectionTable(name = "CONTINENT_COUNTRIES", joinColumns = @JoinColumn(name = "continent_id"))
    @MapKeyColumn(name = "country")
    @Column(name = "capital")
    private Map<String, String> countries = new HashMap<>();

    public Continent() {}
    public Continent(String cname, Map<String, String> countries) {
        this.cname = cname;
        this.countries = countries;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }
    public Map<String, String> getCountries() { return countries; }
    public void setCountries(Map<String, String> countries) { this.countries = countries; }
}