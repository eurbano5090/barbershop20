package com.enurbano.barbershop.service;

import java.util.List;
import java.util.Optional;

import com.enurbano.barbershop.entity.Customer;

public interface CustomerService {

	   Optional<Customer> findById(Long id);

	    List<Customer> findAll();

	    Customer save(Customer customer);

	    boolean deleteById(Long id);
}
