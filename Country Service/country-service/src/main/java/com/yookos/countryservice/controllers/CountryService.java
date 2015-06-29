package com.yookos.countryservice.controllers;

import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.CityData;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;
import org.springframework.hateoas.Resources;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by tshiamotaukobong on 15/05/19.
 */
public interface CountryService {

    List<City> getCitiesByRegion(int rig_id);
    List<Region> getRegionsByCountry(int con_id);
    List<Country> getCountries();
    List<CityData> searchCities(String name, int limit, int pageNo);
    CityData addCityData(WebRequest webRequest);

}
