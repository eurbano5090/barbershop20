package com.enurbano.barbershop.service;

import java.util.List;
import java.util.Optional;

import com.enurbano.barbershop.entity.Employee;

public interface EmployeeService {

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    Employee save(Employee employee);

    boolean deleteById(Long id);

}
