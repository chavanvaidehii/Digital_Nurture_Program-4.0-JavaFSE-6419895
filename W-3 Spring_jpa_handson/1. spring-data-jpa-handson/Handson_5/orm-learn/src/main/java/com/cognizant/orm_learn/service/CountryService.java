package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import java.util.List;

public interface CountryService {
    Country findCountryByCode(String code);
    void addCountry(Country country);
    void updateCountry(String code, Country updatedCountry);
    void deleteCountry(String code);
    List<Country> findCountriesByPartialName(String partialName);
}
