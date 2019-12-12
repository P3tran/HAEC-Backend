package com.example.exploregreece.features.customer;

import com.example.exploregreece.features.tour.Tour;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;
    private CustomerEntityToResponseMapper entityToResponseMapper;
    private CustomerInputToEntityMapper inputToEntityMapper;

    public CustomerService(CustomerRepository repository,
                           CustomerEntityToResponseMapper entityToResponseMapper,
                           CustomerInputToEntityMapper inputToEntityMapper) {
        this.repository = repository;
        this.entityToResponseMapper = entityToResponseMapper;
        this.inputToEntityMapper = inputToEntityMapper;
    }

    //(4) change the return type of the methods to the new model
    // and use the method to map it
    public List<CustomerResponse> getAllCustomers() {
        List<CustomerResponse> customersToReturn = new ArrayList<>();
        Iterable<Customer> retrievedCustomers = repository.findAll();
        for (Customer cust : retrievedCustomers) {
            customersToReturn.add(entityToResponseMapper.mapToCustomerResponse(cust));
        }
        return customersToReturn;
    }

    public List<CustomerResponse> getCustomersByStatus(CustomerStatus status) {
        List<CustomerResponse> customersToReturn = new ArrayList<>();
        Iterable<Customer> retrievedCustomers = repository.findAll();
        for (Customer cust : retrievedCustomers) {
            if (cust.getStatus() == status) {
                CustomerResponse mappedCustomer = entityToResponseMapper.mapToCustomerResponse(cust);
                customersToReturn.add(mappedCustomer);
            }
        }
        return customersToReturn;
    }

    public CustomerResponse updateCustomer(CustomerInput input, long id)
            throws CustomerNotFoundException {
        Optional<Customer> retrievedCustomerOptional = repository.findById(id);
        if(retrievedCustomerOptional.isEmpty())
            throw new CustomerNotFoundException();
        else {
            Customer retrievedCustomer = retrievedCustomerOptional.get();
            Customer customerToUpdate = retrievedCustomer;
            if(input.getLastname() != null)
                customerToUpdate.setLastname(input.getLastname());
            if(input.getName() !=null)
                customerToUpdate.setName(input.getName());
            if(input.getEmail() !=null)
                customerToUpdate.setEmail(input.getEmail());
            if(input.getNumberOfBookings() != null)
                customerToUpdate.setNumberOfBookings(input.getNumberOfBookings());
            if(input.getTelephone() !=null)
                customerToUpdate.setTelephone(input.getTelephone());

            Customer savedCustomer = repository.save(customerToUpdate);
            return entityToResponseMapper.mapToCustomerResponse(savedCustomer);
        }
    }

    //(POST - 3) create a method that returns customer response and accepts customer input
    public CustomerResponse createCustomer(CustomerInput input) {
        Customer customerToSave = inputToEntityMapper.mapInputToEntity(input);
        Customer savedCustomer = repository.save(customerToSave);
        CustomerResponse customerToReturn = entityToResponseMapper.mapToCustomerResponse(savedCustomer);
        return customerToReturn;
    }















    //(POST - 2) create a method that returns customer from customerInput
/*    private Customer mapFromInputToCustomer(CustomerInput input) {
        return new Customer(
                input.getName(),
                input.getLastname(),
                input.getEmail(),
                input.getTelephone(),
                input.getNumberOfBookings(),
                mapCustomerStatus(input.getNumberOfBookings())
        );
    }*/

/*    private CustomerStatus mapCustomerStatus(int numberOfBookings) {
        if(numberOfBookings < 5)
            return CustomerStatus.NEW;
        else if(numberOfBookings <10)
            return CustomerStatus.LOYAL;
        else if(numberOfBookings <15)
            return CustomerStatus.GOLD;
        else
            return CustomerStatus.PLATINUM;
    }*/

    //(2) Create a method that received a database model and returns the new model
/*    private CustomerResponse mapToCustomerResponse(Customer customer) {
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
    }*/
}
