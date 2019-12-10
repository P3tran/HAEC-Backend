package com.example.exploregreece.features.customer;

//(POST-1) create input data transfer object - dto
public class CustomerInput {

    private long id;
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private Integer numberOfBookings;

    public CustomerInput() {
    }

    public CustomerInput(String name, String lastname, String email, String telephone, int numberOfBookings) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.numberOfBookings = numberOfBookings;
    }

    public CustomerInput(long id, String name, String lastname, String email, String telephone, int numberOfBookings) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.numberOfBookings = numberOfBookings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }
}
