package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // HQL (JPQL) - using @Query
    @Query("SELECT e FROM Employee e WHERE e.emSalary > :salary")
    List<Employee> getEmployeesWithSalaryGreaterThan(@Param("salary") double salary);

    // HQL with JOIN FETCH keyword
    @Query("SELECT e FROM Employee e JOIN FETCH e.department WHERE e.emPermanent = true")
    List<Employee> getPermanentEmployeesWithDepartment();

    // Aggregate function in HQL
    @Query("SELECT AVG(e.emSalary) FROM Employee e")
    Double getAverageSalary();

    // Native Query
    @Query(value = "SELECT * FROM employee WHERE em_salary BETWEEN :min AND :max", nativeQuery = true)
    List<Employee> getEmployeesWithSalaryBetween(@Param("min") double min, @Param("max") double max);
}

