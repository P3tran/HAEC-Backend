package com.example.exploregreece.features.tour;


public class TourInput {

    private String title;
    private String shortDescription;
    private int hoursDuration;
    private double price;

    private long tourPackageId;

    public TourInput() {
    }

    public TourInput(String title, String shortDescription, int hoursDuration, double price, long tourPackageId) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.hoursDuration = hoursDuration;
        this.price = price;
        this.tourPackageId = tourPackageId;
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

    public long getTourPackageId() {
        return tourPackageId;
    }

    public void setTourPackageId(long tourPackageId) {
        this.tourPackageId = tourPackageId;
    }
}
