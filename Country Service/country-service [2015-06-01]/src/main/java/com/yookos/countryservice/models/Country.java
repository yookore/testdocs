package com.yookos.countryservice.models;

import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Country extends ResourceSupport{


    private int con_id;
    private String con_name;

    @JsonCreator
    public Country(@JsonProperty("con_id") int con_id,@JsonProperty("con_name") String con_name) {
        this.con_id = con_id;
        this.con_name = con_name;
    }

    public long getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }


    public void setCon_name(String con_name) {
        this.con_name = con_name;
    }

    public String getCon_Name() {
        return con_name;
    }
}
