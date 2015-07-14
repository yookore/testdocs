package com.yookos.countryservice.models;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Country extends ResourceSupport {

    private int country_id;
    private String country_name;

    @JsonCreator
    public Country(@JsonProperty("country_id") int con_id,@JsonProperty("country_name") String con_name) {
        this.country_id = con_id;
        this.country_name = con_name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int con_id) {
        this.country_id = con_id;
    }


    public void setCountry_name(String con_name) {
        this.country_name = con_name;
    }

    public String getCountry_name() {
        return country_name;
    }
}
