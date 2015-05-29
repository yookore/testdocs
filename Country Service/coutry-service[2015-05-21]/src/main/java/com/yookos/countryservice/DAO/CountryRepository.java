package com.yookos.countryservice.DAO;

import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;

import java.sql.Connection;
import java.util.List;

/**
 * Created by tshiamotaukobong on 15/05/19.
 */
public interface CountryRepository {
    void connetToDB();
    List<City> getCitiesByRegionCountry(String country, String region);
    List<Region> getRegionsByCountry(String country);
    List<Country> getCountries();
}
