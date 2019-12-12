package com.example.exploregreece.features.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerEntityToResponseMapper {

    public CustomerResponse mapToCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                mapFullName(customer),
                customer.getEmail(),
                customer.getTelephone(),
                customer.getNumberOfBookings(),
                customer.getStatus()
        );
    }

    private String mapFullName(Customer customer) {
        return customer.getName() + " " + customer.getLastname();
    }
}
