package com.yookos.countryservice.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Region extends ResourceSupport{


    private int region_id;
    private String region_name;
    private int country_id;

    @JsonCreator
    public Region(@JsonProperty("region_id") int rig_id, @JsonProperty("region_name") String rig_name, @JsonProperty("country_id") int con_id) {
        this.region_id = rig_id;
        this.region_name = rig_name;
        this.country_id = con_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int con_id) {
        this.country_id = con_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getRegion_name() {
        return region_name;
    }
}
