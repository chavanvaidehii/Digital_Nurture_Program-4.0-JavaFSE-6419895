package com.cognizant.orm_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dpId;

    private String dpName;

    public int getDpId() { return dpId; }
    public void setDpId(int dpId) { this.dpId = dpId; }

    public String getDpName() { return dpName; }
    public void setDpName(String dpName) { this.dpName = dpName; }
}