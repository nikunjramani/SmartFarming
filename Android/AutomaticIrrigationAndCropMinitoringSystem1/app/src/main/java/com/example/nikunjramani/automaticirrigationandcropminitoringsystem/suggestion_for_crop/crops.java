package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.suggestion_for_crop;

public class crops {
    String crop_name,description,soil_type;

    public crops(String crop_name, String description, String soil_type) {
        this.crop_name = crop_name;
        this.description = description;
        this.soil_type = soil_type;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoil_type() {
        return soil_type;
    }

    public void setSoil_type(String soil_type) {
        this.soil_type = soil_type;
    }
}
