package com.yookos.countryservice.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Region extends ResourceSupport{


    private int rig_id;
    private String rig_name;
    private int con_id;

    @JsonCreator
    public Region(@JsonProperty("rig_id") int rig_id, @JsonProperty("rig_name") String rig_name, @JsonProperty("con_id") int con_id) {
        this.rig_id = rig_id;
        this.rig_name = rig_name;
        this.con_id = con_id;
    }

    public int getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public int getRig_id() {
        return rig_id;
    }

    public void setRig_id(int rig_id) {
        this.rig_id = rig_id;
    }

    public void setRig_name(String rig_name) {
        this.rig_name = rig_name;
    }

    public String getRig_name() {
        return rig_name;
    }
}
