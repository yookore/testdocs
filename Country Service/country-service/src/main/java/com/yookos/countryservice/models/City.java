package com.yookos.countryservice.models;

public class City {


    private int cit_id;
    private String cit_name;
    private int rig_id;
    public City(int cit_id, String cit_name, int rig_id) {
        this.cit_id = cit_id;
        this.cit_name = cit_name;
        this.rig_id = rig_id;
    }

    public int getRig_id() {
        return rig_id;
    }

    public void setRig_id(int rig_id) {
        this.rig_id = rig_id;
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

    public String getCit_name() {
        return cit_name;
    }
}
