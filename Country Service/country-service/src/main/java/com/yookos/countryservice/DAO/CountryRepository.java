package com.yookos.countryservice.DAO;

import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.CityData;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

/**
 * Created by tshiamotaukobong on 15/05/19.
 */

public interface CountryRepository {
    void connetToDB();
    List<City> getCitiesByRegion(int rig_id);
    List<Region> getRegionsByCountry(int con_id);
    List<Country> getCountries();
    List<CityData> searchCities(String name, int limit, int pageNo);
    CityData addCityData(String cit_name, String rig_name, String con_name);
    void setDbDriver(String dbDriver);
    void setDbUrl(String dbUrl);
    void setDbPassword(String dbPassword);
    Connection getCon();
    void closeConnection();
}
