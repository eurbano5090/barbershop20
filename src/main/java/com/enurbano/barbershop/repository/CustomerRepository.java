package com.enurbano.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enurbano.barbershop.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
