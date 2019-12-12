package com.example.exploregreece.features.customer;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomerEntityToResponseMapper implements Function<Customer, CustomerResponse> {

    private String mapFullName(Customer customer) {
        return customer.getName() + " " + customer.getLastname();
    }

    @Override
    public CustomerResponse apply(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                mapFullName(customer),
                customer.getEmail(),
                customer.getTelephone(),
                customer.getNumberOfBookings(),
                customer.getStatus()
        );
    }
}
