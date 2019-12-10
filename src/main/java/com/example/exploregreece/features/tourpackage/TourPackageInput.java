package com.example.exploregreece.features.tourpackage;

import javax.persistence.Column;

public class TourPackageInput {

    private String title;
    private String description;
    private double price;
    private int duration;
    private Destination dest;

    public TourPackageInput() {
    }

    public TourPackageInput(String title, String description, double price, int duration, Destination dest) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.dest = dest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Destination getDest() {
        return dest;
    }

    public void setDest(Destination dest) {
        this.dest = dest;
    }
}
