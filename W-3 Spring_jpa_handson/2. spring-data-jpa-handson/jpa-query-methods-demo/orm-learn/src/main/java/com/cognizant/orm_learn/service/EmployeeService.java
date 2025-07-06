package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void runQueries() {
        System.out.println("Containing 'a': " + employeeRepository.findByEmNameContainingIgnoreCase("a"));
        System.out.println("Starting with 'A': " + employeeRepository.findByEmNameStartingWith("A"));
        System.out.println("Sorted by salary: " + employeeRepository.findAllByOrderByEmSalaryDesc());

        Date start = Date.valueOf("1989-01-01");
        Date end = Date.valueOf("1992-12-31");
        System.out.println("DOB between 1989 and 1992: " + employeeRepository.findByEmDateOfBirthBetween(start, end));

        System.out.println("Salary > 60000: " + employeeRepository.findByEmSalaryGreaterThan(60000));
        System.out.println("Salary < 60000: " + employeeRepository.findByEmSalaryLessThan(60000));
        System.out.println("Top 2 earners: " + employeeRepository.findTop2ByOrderByEmSalaryDesc());
    }
}

