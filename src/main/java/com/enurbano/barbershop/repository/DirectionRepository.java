package com.enurbano.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enurbano.barbershop.entity.Direction;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long>{

}
