package com.example.exploregreece.features.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// (1) The repositories give us access to the table of the respective entity
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
