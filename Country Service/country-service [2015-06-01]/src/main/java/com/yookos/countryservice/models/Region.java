package com.yookos.countryservice.models;

public class Region {


    private int rig_id;
    private String rig_name;

    public Region(int rig_id, String rig_name) {
        this.rig_id = rig_id;
        this.rig_name = rig_name;
    }

    public long getRig_id() {
        return rig_id;
    }

    public void setRig_id(int rig_id) {
        this.rig_id = rig_id;
    }

    public void setRig_name(String rig_name) {
        this.rig_name = rig_name;
    }

    public String getRig_Name() {
        return rig_name;
    }
}
