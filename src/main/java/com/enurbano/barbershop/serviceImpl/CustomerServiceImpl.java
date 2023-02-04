package com.enurbano.barbershop.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.enurbano.barbershop.entity.Customer;
import com.enurbano.barbershop.repository.CustomerRepository;
import com.enurbano.barbershop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return customerRepository.findById(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        if(customer == null || !StringUtils.hasLength(customer.getEmail()))
            throw new IllegalArgumentException("Email de cliente incorrecto");

        return customerRepository.save(customer);
    }

    public boolean deleteById(Long id) {
        if(id == null || !customerRepository.existsById(id))
            return false;

        customerRepository.deleteById(id);

        return true;
    }
}
