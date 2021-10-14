package com.example.demoformulairespring.Repository;

import com.example.demoformulairespring.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
