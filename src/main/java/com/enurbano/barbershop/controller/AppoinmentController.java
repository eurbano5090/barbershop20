package com.enurbano.barbershop.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enurbano.barbershop.dto.BenefitsDTO;
import com.enurbano.barbershop.entity.Appointment;
import com.enurbano.barbershop.service.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppoinmentController {

	@Autowired
	private  AppointmentService appointmentService;


    public AppoinmentController(AppointmentService appointmentService) {
    	super();
		this.appointmentService = appointmentService;
	}

	/**
     * GET http://localhost:8085/api/appointments
     */
    @GetMapping("/appointments")
    public List<Appointment> findAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/appointments/search/customer/email/{email}")
    public List<Appointment> findAllByCustomerEmail(@PathVariable String email){
        return appointmentService.findAllByCustomerEmail(email);
    }


    @GetMapping("/appointments/search/employee/dni/{dni}")
    public List<Appointment> findAllByEmployeeDni(@PathVariable String dni){
        return appointmentService.findAllByEmployeeDni(dni);
    }

    @GetMapping("/appointments/search/hair-assistance/price/{price}")
    public List<Appointment> findAllByPriceLessThanEqual(@PathVariable Double price){
        return appointmentService.findAllByPriceLessThanEqual(price);
    }

    /**
     * GET http://localhost:8085/api/appointments/1
     * GET http://localhost:8085/api/appointments/2
     */
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id){

        Optional<Appointment> appointmentOpt = appointmentService.findById(id);
        if(appointmentOpt.isPresent())
            return ResponseEntity.ok(appointmentOpt.get());

        return ResponseEntity.notFound().build(); // 404

//        return appointmentService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crea una nueva cita
     * POST http://localhost:8085/api/appointments
     */
    @PostMapping("/appointments")
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment){
        if (appointment.getId() != null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    /**
     * Actualizar una cita existente
     * PUT http://localhost:8085/api/appointments
     */
    @PutMapping("/appointments")
    public ResponseEntity<Appointment> update(@RequestBody Appointment appointment){
        if (appointment.getId() == null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = appointmentService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }


    @GetMapping("/appointments/benefits/{year}/{month}/{day}")
    public ResponseEntity<BenefitsDTO> calculateBenefitsByDate(@PathVariable int year, @PathVariable int month, @PathVariable int day){
        double benefits = appointmentService.calculateBenefitsByDate(LocalDate.of(year, month, day));
        BenefitsDTO benefitsDTO = new BenefitsDTO(benefits);
        return ResponseEntity.ok(benefitsDTO);
    }

    @GetMapping("/appointments/benefits/{year}/{month}")
    public ResponseEntity<BenefitsDTO> calculateBenefitsByMonth(@PathVariable int year, @PathVariable int month){
        double benefits = appointmentService.calculateBenefitsByMonth(year, Month.of(month));
        BenefitsDTO benefitsDTO = new BenefitsDTO(benefits);
        return ResponseEntity.ok(benefitsDTO);
    }

    @GetMapping("/appointments/benefits/{year}")
    public ResponseEntity<BenefitsDTO> calculateBenefitsByYear(@PathVariable int year){
        double benefits = appointmentService.calculateBenefitsByYear(year);
        BenefitsDTO benefitsDTO = new BenefitsDTO(benefits);
        return ResponseEntity.ok(benefitsDTO);
    }

}
