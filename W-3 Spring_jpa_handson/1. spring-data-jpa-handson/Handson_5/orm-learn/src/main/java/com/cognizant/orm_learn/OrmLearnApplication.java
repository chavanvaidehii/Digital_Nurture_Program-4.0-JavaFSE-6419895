package com.cognizant.orm_learn;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("====================================");
		System.out.println(" STARTING COUNTRY OPERATIONS DEMO");
		System.out.println("====================================");

		// 1. Find by country code
		System.out.println("Finding Country by Code: IN");
		Country in = countryService.findCountryByCode("IN");
		System.out.println(" Country Found: " + in);

		// 2. Add new country
		System.out.println("Adding New Country (ZZ, Zootopia)");
		Country newCountry = new Country();
		newCountry.setCode("ZZ");
		newCountry.setName("Zootopia");
		countryService.addCountry(newCountry);
		System.out.println("Added: " + newCountry);

		// 3. Update country
		System.out.println("Updating Country (ZZ) to 'Zootopian Republic'");
		newCountry.setName("Zootopian Republic");
		countryService.updateCountry(newCountry.getCode(), newCountry);
		System.out.println("Updated: " + newCountry);

		// 4. Search by partial name
		System.out.println("Searching Countries containing 'United'");
		List<Country> matched = countryService.findCountriesByPartialName("United");
		matched.forEach(c -> System.out.println("Match: " + c));

		// 5. Delete country
		System.out.println("Deleting Country with Code: ZZ");
		countryService.deleteCountry("ZZ");
		System.out.println(" Deleted Country: ZZ");

		System.out.println("====================================");
		System.out.println(" END OF COUNTRY OPERATIONS");
		System.out.println("====================================");
	}
}
