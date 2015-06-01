package com.yookos.countryservice.controllers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.DAO.Impl.CountryRepositoryImpl;
import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController implements CountryService {

    private static final String template = "Hello, %s!";
    private CountryRepository conRepository = new CountryRepositoryImpl();


    private final AtomicLong counter = new AtomicLong();

    @Override @RequestMapping(value={"/countryservice/{country}/{region}/cities"}, method = RequestMethod.GET)
    public List<City> getCitiesByRegionCountry(@PathVariable("country") String country, @PathVariable("region") String region) {
        return conRepository.getCitiesByRegionCountry(country,region);
    }

    @Override @RequestMapping(value = {"/countryservice/{country}/regions"}, method = RequestMethod.GET)
    public List<Region> getRegionsByCountry(@PathVariable("country") String country) {
        return conRepository.getRegionsByCountry(country);
    }

    @Override @RequestMapping(value = {"/countryservice/countries"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Country> getCountries() {
        List<Country> countryList = conRepository.getCountries();
        countryList.add(linkTo(methodOn(CountryContoller.class).getCountries()).withSelfRel());
        return countryList;
    }

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
