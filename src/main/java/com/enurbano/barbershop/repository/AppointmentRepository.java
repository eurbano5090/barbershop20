package com.enurbano.barbershop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enurbano.barbershop.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{

	 List<Appointment> findAllByCustomerEmail(String email);

	    List<Appointment> findAllByCustomerId(Long id);

	    List<Appointment> findAllByDateBetween(LocalDateTime min, LocalDateTime max);

	    List<Appointment> findAllByHairAssistanceId(Long id);

	    List<Appointment> findAllByEmployeeId(Long id);

	    List<Appointment> findAllByEmployeeDni(String dni);

	    List<Appointment> findAllByHairAssistancePriceLessThanEqual(Double price);

	    List<Appointment> findAllByIdNotInAndCustomerId(List<Long> ids, Long id);
	    
	    
}
