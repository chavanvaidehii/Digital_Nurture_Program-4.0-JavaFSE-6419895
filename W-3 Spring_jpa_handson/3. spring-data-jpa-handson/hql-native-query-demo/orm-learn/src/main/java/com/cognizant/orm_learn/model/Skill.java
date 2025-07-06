package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skId;

    private String skName;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public int getSkId() { return skId; }
    public void setSkId(int skId) { this.skId = skId; }
    public String getSkName() { return skName; }
    public void setSkName(String skName) { this.skName = skName; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}
