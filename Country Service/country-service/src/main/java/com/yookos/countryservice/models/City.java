package com.yookos.countryservice.models;

public class City {


    private int city_id;
    private String city_name;
    private int region_id;
    public City(int cit_id, String cit_name, int rig_id) {
        this.city_id = cit_id;
        this.city_name = cit_name;
        this.region_id = rig_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int rig_id) {
        this.region_id = rig_id;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(int cit_id) {
        this.city_id = cit_id;
    }

    public void setCity_name(String cit_name) {
        this.city_name = cit_name;
    }

    public String getCity_name() {
        return city_name;
    }
}
