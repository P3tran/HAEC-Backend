package com.example.exploregreece.features.customer;

//(1) This model-pojo represents the information as the front end needs it
//has nothing to do with spring boot, therefore it requires no annotation or default constructor
public class CustomerResponse {

    private long id;
    private String fullname;
    private String email;
    private String telephone;
    private int numberOfBookings;
    private CustomerStatus status;

    public CustomerResponse(long id, String fullname, String email, String telephone, int numberOfBookings, CustomerStatus status) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.telephone = telephone;
        this.numberOfBookings = numberOfBookings;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }
}
