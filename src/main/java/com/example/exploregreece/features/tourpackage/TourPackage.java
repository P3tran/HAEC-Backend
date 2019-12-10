package com.example.exploregreece.features.tourpackage;

import javax.persistence.*;

@Entity // (name = "MY_TABLE_NAME")
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(name = "desc")
    private String description;

    private double price;
    private int duration;
    private Destination dest;

    public TourPackage() {
    }

    public TourPackage(String title, String description, double price, int duration, Destination dest) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.dest = dest;
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
}
