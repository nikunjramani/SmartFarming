package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize;

import java.util.List;

public class crop {
    String crop_prize;
    String crop_name;

    public crop(String crop_prize, String crop_name) {
        this.crop_prize = crop_prize;
        this.crop_name = crop_name;
    }

    public String getCrop_prize() {
        return crop_prize;
    }

    public void setCrop_prize(String crop_prize) {
        this.crop_prize = crop_prize;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }
}
