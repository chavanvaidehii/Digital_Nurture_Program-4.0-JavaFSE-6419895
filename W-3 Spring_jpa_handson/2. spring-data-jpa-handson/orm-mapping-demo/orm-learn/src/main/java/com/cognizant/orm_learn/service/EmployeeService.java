package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void runOrmMappingDemo() {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee e : employees) {
            System.out.println("Employee: " + e.getEmName());
            System.out.println("  Department: " + e.getDepartment().getDpName());

            System.out.println("  Skills:");
            for (Skill s : e.getSkills()) {
                System.out.println("    - " + s.getSkName());
            }
        }
    }
}
