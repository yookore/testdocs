package com.yookos.countryservice.models;

/**
 * Created by tshiamotaukobong on 15/07/14.
 */
public class PostCityData {
    private String country, region, city;


    public PostCityData() {}

    public PostCityData(String country, String region, String city) {
        this.country = country;
        this.region = region;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
