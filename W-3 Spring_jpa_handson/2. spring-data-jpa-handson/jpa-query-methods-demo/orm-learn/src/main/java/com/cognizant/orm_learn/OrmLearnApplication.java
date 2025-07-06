package com.cognizant.orm_learn;

import com.cognizant.orm_learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==========================================");
		System.out.println("   SPRING DATA JPA - QUERY METHODS DEMO   ");
		System.out.println("==========================================");

		System.out.println("STEP 1: Running employee query methods...");
		employeeService.runQueries();
		System.out.println("STEP 1 Complete.");

		System.out.println("STEP 2: Additional processing (if any)..."); // Placeholder if you add more steps later
		// You can call other service methods here
		System.out.println("STEP 2 Complete.");

		System.out.println("STEP 3: Wrapping up demo...");
		System.out.println("Thank you for running the demo!");
		System.out.println("==========================================");
	}
}
