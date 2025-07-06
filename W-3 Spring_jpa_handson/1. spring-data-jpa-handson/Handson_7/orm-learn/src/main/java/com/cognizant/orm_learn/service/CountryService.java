package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country findCountryByCode(String code) throws CountryNotFoundException;
    void addCountry(Country country);
    void updateCountry(String code, Country updatedCountry) throws CountryNotFoundException;
    void deleteCountry(String code) throws CountryNotFoundException;
    List<Country> findCountriesByPartialName(String name);
}
