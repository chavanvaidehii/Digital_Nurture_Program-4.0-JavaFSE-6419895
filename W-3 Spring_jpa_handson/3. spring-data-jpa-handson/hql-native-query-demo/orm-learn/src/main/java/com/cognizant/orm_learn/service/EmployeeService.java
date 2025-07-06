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

        System.out.println("\n--- HQL: Employees with salary > 60000 ---");
        employeeRepository.getEmployeesWithSalaryGreaterThan(60000).forEach(
                e -> System.out.println(e.getEmName() + " - " + e.getEmSalary())
        );

        System.out.println("\n--- HQL FETCH JOIN: Permanent Employees with Department ---");
        employeeRepository.getPermanentEmployeesWithDepartment().forEach(
                e -> System.out.println(e.getEmName() + " (" + e.getDepartment().getDpName() + ")")
        );

        System.out.println("\n--- HQL Aggregate Function: Average Salary ---");
        System.out.println("Average Salary: " + employeeRepository.getAverageSalary());

        System.out.println("\n--- Native Query: Employees with salary between 50000 and 80000 ---");
        employeeRepository.getEmployeesWithSalaryBetween(50000, 80000).forEach(
                e -> System.out.println(e.getEmName() + " - " + e.getEmSalary())
        );
    }
}
