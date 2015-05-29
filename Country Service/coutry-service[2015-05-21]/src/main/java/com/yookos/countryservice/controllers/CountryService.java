package com.yookos.countryservice.controllers;

import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;

import java.util.List;


/**
 * Created by tshiamotaukobong on 15/05/19.
 */
public interface CountryService {
    List<City> getCitiesByRegionCountry(String country, String region);
    List<Region> getRegionsByCountry(String country);
    List<Country> getCountries();
}
