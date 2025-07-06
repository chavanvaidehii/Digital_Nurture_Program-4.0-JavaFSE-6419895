package com.cognizant.orm_learn.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.sql.Date;
import java.util.List;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.FetchType;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emId;

    private String emName;
    private double emSalary;
    private boolean emPermanent;
    private Date emDateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "em_dp_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_skill",
            joinColumns = @JoinColumn(name = "es_em_id"),
            inverseJoinColumns = @JoinColumn(name = "es_sk_id")
    )
    private List<Skill> skills;

    public int getEmId() { return emId; }
    public void setEmId(int emId) { this.emId = emId; }
    public String getEmName() { return emName; }
    public void setEmName(String emName) { this.emName = emName; }
    public double getEmSalary() { return emSalary; }
    public void setEmSalary(double emSalary) { this.emSalary = emSalary; }
    public boolean isEmPermanent() { return emPermanent; }
    public void setEmPermanent(boolean emPermanent) { this.emPermanent = emPermanent; }
    public Date getEmDateOfBirth() { return emDateOfBirth; }
    public void setEmDateOfBirth(Date emDateOfBirth) { this.emDateOfBirth = emDateOfBirth; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }
}

