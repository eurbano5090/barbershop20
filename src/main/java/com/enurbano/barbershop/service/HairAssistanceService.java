package com.enurbano.barbershop.service;

import java.util.List;
import java.util.Optional;

import com.enurbano.barbershop.entity.HairAssistance;

public interface HairAssistanceService {

	   Optional<HairAssistance> findById(Long id);

	    List<HairAssistance> findAll();

	    HairAssistance save(HairAssistance hairAssistance);

	    boolean deleteById(Long id);
}
