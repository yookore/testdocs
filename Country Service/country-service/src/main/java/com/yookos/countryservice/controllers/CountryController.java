package com.yookos.countryservice.controllers;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.DAO.Impl.CountryRepositoryImpl;
import com.yookos.countryservice.exceptions.ResourceNotFoundException;
import com.yookos.countryservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.FilterConfig;

@RestController
@RequestMapping("/api/v1/countryservice")
public class CountryController implements CountryService {


    private CountryRepository conRepository;

    @Autowired
    public CountryController(CountryRepository conRepository) {
       this.conRepository = conRepository;
        this.conRepository.connetToDB();
    }

    @Override
    @RequestMapping(value={"/regions/{rig_id}/cities"}, method = RequestMethod.GET)
    public List<City> getCitiesByRegion(@PathVariable("rig_id") int rig_id) {
        List<City> cities = conRepository.getCitiesByRegion(rig_id);
        if(cities.size()==0) throw new ResourceNotFoundException("Region id " + rig_id + " doesn't exist");
        return cities;
    }

    @Override
    @RequestMapping(value = {"/countries/{con_id}/regions"}, method = RequestMethod.GET)
    public List<Region> getRegionsByCountry(@PathVariable("con_id") int con_id) {
        List<Region> regionList = conRepository.getRegionsByCountry(con_id);
        if(regionList.size()==0) throw new ResourceNotFoundException("Country id " + con_id + " doesn't exist");
        for(Region region: regionList)
            region.add(linkTo(methodOn(CountryController.class).getCitiesByRegion(region.getRegion_id())).withRel("cities"));
        return regionList;
    }

    @Override
    @RequestMapping(value = {"/countries"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Country> getCountries() {
        List<Country> countryList = conRepository.getCountries();
        for(Country country : countryList)
            country.add(linkTo(methodOn(CountryController.class).getRegionsByCountry(country.getCountry_id())).withRel("regions"));
        return countryList;
    }

    @Override
    @RequestMapping(value = {"/cities/{city}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<CityData> searchCities(@PathVariable(value = "city") String name, @RequestParam(defaultValue = "40",value = "results",required = false) int limit,
                                       @RequestParam(defaultValue = "1",value = "page",required = false) int pageNo){

        List<CityData> cityData = conRepository.searchCities(name, limit, pageNo);
        if(cityData.size()==0) throw new ResourceNotFoundException("No results found for city " + name);
        return cityData;
    }

    @Override
    @RequestMapping(value = "/cities", method = RequestMethod.POST, consumes="application/json", produces="application/json;charset=UTF-8")
    @ResponseBody
    public CityData addCityData(@RequestBody PostCityData postCityData) {
        String cit_name = postCityData.getCity(), rig_name = postCityData.getRegion(),
                con_name = postCityData.getCountry();

        if(cit_name!=null && con_name!=null)
        {
            if(rig_name==null) rig_name="Other";
            return conRepository.addCityData(cit_name,rig_name,con_name);
        }
        return null;
    }

    public void setConRepository(CountryRepositoryImpl conRepository) {
        this.conRepository = conRepository;
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
    /* @RequestMapping(value={"/countryservice/region/{name}/cities/{tmp}","/countryservice/region/{name}/cities"}, method = RequestMethod.GET)
    public List<City> getCitiesByCountry(@PathVariable Map<String, String> pathVariables, @PathVariable("name") String name) {
        City c = null;
        *//*if(pathVariables.containsKey("tmp"))
        c = new City(counter.incrementAndGet(),0,
                String.format(template, name) +" "+ pathVariables.get("tmp"));
        else
            c = new City(counter.incrementAndGet(),0,
                    String.format(template, name));*//*

        return null;
    }*/
}
