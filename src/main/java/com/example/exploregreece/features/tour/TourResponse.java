package com.example.exploregreece.features.tour;

import com.example.exploregreece.features.tourpackage.TourPackage;

public class TourResponse {

    private long id;
    private String title;
    private String shortDescription;
    private int hoursDuration;
    private double price;
    private TourPackage tourPackage;
    private double pricePerHour;
    private DurationType durationType;

    public TourResponse() {
    }

    public TourResponse(long id, String title, String shortDescription, int hoursDuration, double price, TourPackage tourPackage, double pricePerHour, DurationType durationType) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.hoursDuration = hoursDuration;
        this.price = price;
        this.tourPackage = tourPackage;
        this.pricePerHour = pricePerHour;
        this.durationType = durationType;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getHoursDuration() {
        return hoursDuration;
    }

    public void setHoursDuration(int hoursDuration) {
        this.hoursDuration = hoursDuration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }
}
