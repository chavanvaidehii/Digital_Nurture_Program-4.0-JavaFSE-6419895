package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // Get country by code
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry");
        Country country = countryService.getCountry(code);
        LOGGER.info("END - getCountry");
        return country;
    }

    // Get first two countries from the XML list
    @GetMapping("/countries/two")
    public List<Country> getTwoCountries() {
        LOGGER.info("START - getTwoCountries");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", List.class);

        // Return first two countries
        List<Country> twoCountries = countryList.subList(0, 2);

        LOGGER.info("END - getTwoCountries");
        return twoCountries;
    }
}
