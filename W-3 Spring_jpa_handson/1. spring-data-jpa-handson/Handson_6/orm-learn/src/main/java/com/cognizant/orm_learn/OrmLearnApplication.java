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

		LOGGER.info("=======================================");
		LOGGER.info("        ORM LEARN APPLICATION STARTED  ");
		LOGGER.info("=======================================");

		getAllCountriesTest();
		getCountryTest();

		LOGGER.info("=======================================");
		LOGGER.info("        ORM LEARN APPLICATION ENDED    ");
		LOGGER.info("=======================================");
	}

	private static void getAllCountriesTest() {
		LOGGER.info("---------------------------------------");
		LOGGER.info("           GET ALL COUNTRIES           ");
		LOGGER.info("---------------------------------------");

		List<Country> countries = countryService.getAllCountries();
		for (Country c : countries) {
			LOGGER.info("Country Code: {}, Country Name: {}", c.getCode(), c.getName());
		}

		LOGGER.info("---------------------------------------");
	}

	private static void getCountryTest() {
		LOGGER.info("****************************************");
		LOGGER.info("           GET COUNTRY BY CODE          ");
		LOGGER.info("****************************************");

		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.info(" Country found - Code: {}, Name: {}", country.getCode(), country.getName());
		} catch (CountryNotFoundException e) {
			LOGGER.error(" CountryNotFoundException: {}", e.getMessage());
		}

		LOGGER.info("****************************************");
	}
}
