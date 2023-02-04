package com.enurbano.barbershop.service;

import java.util.List;
import java.util.Optional;

import com.enurbano.barbershop.entity.Direction;

public interface DirectionService {

	   Optional<Direction> findById(Long id);

	    List<Direction> findAll();

	    Direction save(Direction direction);

	    boolean deleteById(Long id);
}
