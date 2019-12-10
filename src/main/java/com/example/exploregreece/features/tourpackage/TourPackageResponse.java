package com.example.exploregreece.features.tourpackage;

import javax.persistence.Column;

public class TourPackageResponse {

    private long id;
    private String title;
    private String description;
    private double price;
    private int duration;
    private Destination dest;
    private double pricePerDay;

    public TourPackageResponse(long id, String title, String description, double price, int duration, Destination dest, double pricePerDay) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.dest = dest;
        this.pricePerDay = pricePerDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
