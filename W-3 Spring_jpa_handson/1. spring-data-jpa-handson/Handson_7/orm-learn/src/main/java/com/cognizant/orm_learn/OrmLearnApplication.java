package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		getAllCountriesTest();
		getCountryTest();
		testAddCountry();
	}

	private static void getAllCountriesTest() {
		LOGGER.info("\n=== getAllCountriesTest ===");
		List<Country> countries = countryService.getAllCountries();
		for (Country c : countries) {
			LOGGER.info("Country: {} - {}", c.getCode(), c.getName());
		}
	}

	private static void getCountryTest() {
		LOGGER.info("\n=== getCountryTest ===");
		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.info("Found Country: {} - {}", country.getCode(), country.getName());
		} catch (CountryNotFoundException e) {
			LOGGER.error("Error: {}", e.getMessage());
		}
	}

	private static void testAddCountry() {
		LOGGER.info("\n=== testAddCountry ===");
		Country newCountry = new Country();
		newCountry.setCode("XY");
		newCountry.setName("Xylophonia");

		countryService.addCountry(newCountry);
		LOGGER.info("Added new country: XY - Xylophonia");

		try {
			Country fetched = countryService.findCountryByCode("XY");
			LOGGER.info("Retrieved Country: {} - {}", fetched.getCode(), fetched.getName());
		} catch (CountryNotFoundException e) {
			LOGGER.error("Error: {}", e.getMessage());
		}
	}
}
