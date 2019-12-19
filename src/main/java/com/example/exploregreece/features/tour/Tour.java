package com.example.exploregreece.features.tour;

import com.example.exploregreece.features.tourpackage.TourPackage;

import javax.persistence.*;

//(1)
@Entity(name="tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String shortDescription;
    private int hoursDuration;
    private double price;

    @ManyToOne
    private TourPackage tourPackage;

    public Tour() {
    }

    public Tour(String title, String shortDescription, int hoursDuration, double price, TourPackage tourPackage) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.hoursDuration = hoursDuration;
        this.price = price;
        this.tourPackage = tourPackage;
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

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }
}
