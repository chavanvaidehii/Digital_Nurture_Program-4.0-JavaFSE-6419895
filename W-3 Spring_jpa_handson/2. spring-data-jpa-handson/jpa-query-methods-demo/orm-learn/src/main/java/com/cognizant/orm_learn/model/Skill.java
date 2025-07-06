package com.cognizant.orm_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skId;

    private String skName;

    public int getSkId() { return skId; }
    public void setSkId(int skId) { this.skId = skId; }

    public String getSkName() { return skName; }
    public void setSkName(String skName) { this.skName = skName; }
}