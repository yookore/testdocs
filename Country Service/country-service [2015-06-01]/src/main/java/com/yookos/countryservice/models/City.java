package com.yookos.countryservice.models;

public class City {


    private int cit_id;
    private String cit_name;

    public City(int cit_id, String cit_name) {
        this.cit_id = cit_id;
        this.cit_name = cit_name;
    }

    public long getCit_id() {
        return cit_id;
    }

    public void setCit_id(int cit_id) {
        this.cit_id = cit_id;
    }

    public void setCit_name(String cit_name) {
        this.cit_name = cit_name;
    }

    public String getCit_Name() {
        return cit_name;
    }
}
