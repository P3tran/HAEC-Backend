package com.example.exploregreece.features.customer;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomerInputToEntityMapper {

    public Customer mapInputToEntity(CustomerInput input) {
        return new Customer(
                input.getName(),
                input.getLastname(),
                input.getEmail(),
                input.getTelephone(),
                input.getNumberOfBookings(),
                mapCustomerStatus(input.getNumberOfBookings())
        );
    }

    private CustomerStatus mapCustomerStatus(int numberOfBookings) {
        if (numberOfBookings < 5)
            return CustomerStatus.NEW;
        else if (numberOfBookings < 10)
            return CustomerStatus.LOYAL;
        else if (numberOfBookings < 15)
            return CustomerStatus.GOLD;
        else
            return CustomerStatus.PLATINUM;
    }
}
