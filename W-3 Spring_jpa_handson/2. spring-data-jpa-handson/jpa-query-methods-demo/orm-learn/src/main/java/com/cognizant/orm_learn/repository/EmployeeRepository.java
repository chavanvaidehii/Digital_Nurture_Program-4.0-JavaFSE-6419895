package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmNameContainingIgnoreCase(String keyword);
    List<Employee> findByEmNameStartingWith(String prefix);
    List<Employee> findAllByOrderByEmSalaryDesc();
    List<Employee> findByEmDateOfBirthBetween(Date startDate, Date endDate);
    List<Employee> findByEmSalaryGreaterThan(double salary);
    List<Employee> findByEmSalaryLessThan(double salary);
    List<Employee> findTop2ByOrderByEmSalaryDesc();
}