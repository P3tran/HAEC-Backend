package com.example.exploregreece.features.customer;

import com.example.exploregreece.features.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    //(5) change the controller return type
    @GetMapping(path = "all-customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return new ResponseEntity<>(
                service.getAllCustomers(),
                HttpStatus.OK
        );
    }

    //(Err 2) change the return type to response entity
    @GetMapping(path = "customers-by-status/{status}")
    public ResponseEntity getCustomersByStatus(@PathVariable String status) {
        if (status.equalsIgnoreCase("new"))
            //(Err 3) successful results
            return new ResponseEntity(service.getCustomersByStatus(CustomerStatus.NEW), HttpStatus.OK);
        else if (status.equalsIgnoreCase("loyal"))
            return new ResponseEntity(service.getCustomersByStatus(CustomerStatus.LOYAL), HttpStatus.OK);
        else if (status.equalsIgnoreCase("gold"))
            return new ResponseEntity(service.getCustomersByStatus(CustomerStatus.GOLD), HttpStatus.OK);
        else if (status.equalsIgnoreCase("platinum"))
            return new ResponseEntity(service.getCustomersByStatus(CustomerStatus.PLATINUM), HttpStatus.OK);
        else
            //(Err 4) error results
            return new ResponseEntity(new CustomError(0, "Wrong customer status", "Customer status must be one of: new, loyal, gold, platinum"),
                    HttpStatus.BAD_REQUEST);
    }

    //(POST - 4) Create post endpoint that uses the service method
    // optionally adds some validation
    @PostMapping(path = "create-customer")
    public ResponseEntity createCustomer(@RequestBody CustomerInput customerInput) {
        if (!customerInput.getEmail().contains("@"))
            return new ResponseEntity(new CustomError(0, "Wrong Email", "Email must contain @"), HttpStatus.BAD_REQUEST);
        else if (customerInput.getName().length() < 3 || customerInput.getLastname().length() < 3)
            return new ResponseEntity(new CustomError(0, "Wrong fullname", "Firstname & lastname must have more than 2 characters"), HttpStatus.BAD_REQUEST);

        return new ResponseEntity(service.createCustomer(customerInput), HttpStatus.CREATED);
    }

    @PatchMapping(path = "update-customer/{id}")
    public ResponseEntity updateCustomer(@RequestBody CustomerInput input,
                                         @PathVariable long id) {
        try {
            CustomerResponse customerResponse = service.updateCustomer(input, id);
            return new ResponseEntity(customerResponse, HttpStatus.OK);
        } catch (CustomerNotFoundException cEx) {
            CustomError error = new CustomError(0, "Wrong input", "The customer does not exist");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            CustomError error = new CustomError(0, "Wrong", "Something went wrong");
            return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
