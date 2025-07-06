package com.cognizant.orm_learn.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;


@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dpId;

    private String dpName;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public int getDpId() { return dpId; }
    public void setDpId(int dpId) { this.dpId = dpId; }
    public String getDpName() { return dpName; }
    public void setDpName(String dpName) { this.dpName = dpName; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}


