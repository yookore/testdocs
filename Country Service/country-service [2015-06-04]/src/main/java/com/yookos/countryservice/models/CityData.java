package com.yookos.countryservice.models;

/**
 * Created by tshiamotaukobong on 15/05/28.
 */
public class CityData {
    private City city;
    private Region region;
    private Country country;

    public CityData(City city, Region region, Country country) {
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public Region getRegion() {
        return region;
    }

    public Country getCountry() {
        return country;
    }
}
