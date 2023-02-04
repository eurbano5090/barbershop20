package com.enurbano.barbershop.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enurbano.barbershop.entity.Direction;
import com.enurbano.barbershop.repository.DirectionRepository;
import com.enurbano.barbershop.service.AppointmentService;
import com.enurbano.barbershop.service.DirectionService;

@Service
public class DirectionServiceImpl implements DirectionService{

	private final DirectionRepository directionRepository;

    private final AppointmentService appointmentService;

    public DirectionServiceImpl(DirectionRepository directionRepository,
                                AppointmentService appointmentService) {
        this.directionRepository = directionRepository;
        this.appointmentService = appointmentService;
    }

    @Override
    public Optional<Direction> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return directionRepository.findById(id);
    }

    @Override
    public List<Direction> findAll() {
        return directionRepository.findAll();
    }

    @Override
    public Direction save(Direction direction) {
        if(direction == null)
            throw new IllegalArgumentException("Argumento Direction incorrecto");

        return directionRepository.save(direction);

    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !directionRepository.existsById(id))
            return false;

        directionRepository.deleteById(id);

        return true;
}}
