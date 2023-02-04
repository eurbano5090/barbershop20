package com.enurbano.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enurbano.barbershop.entity.HairAssistance;

@Repository
public interface HairAssistanceRepository extends JpaRepository<HairAssistance, Long>{

}
