package com.enurbano.barbershop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enurbano.barbershop.entity.HairAssistance;
import com.enurbano.barbershop.service.HairAssistanceService;

@RestController
@RequestMapping("/api")
public class HairAssistanceController {

	  private final HairAssistanceService hairAssistanceService;

	    public HairAssistanceController(HairAssistanceService hairAssistanceService) {
	        this.hairAssistanceService = hairAssistanceService;
	    }

	    @GetMapping("/hair-assistances")
	    public List<HairAssistance> findAll(){
	        return hairAssistanceService.findAll();
	    }

	    @GetMapping("/hair-assistances/{id}")
	    public ResponseEntity<HairAssistance> findById(@PathVariable Long id){
	        Optional<HairAssistance> hairAssistanceOpt = hairAssistanceService.findById(id);
	        return hairAssistanceOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	    }

	    @PostMapping("/hair-assistances")
	    public ResponseEntity<HairAssistance> create(@RequestBody HairAssistance hairAssistance){
	        if (hairAssistance.getId() != null)
	            return ResponseEntity.badRequest().build(); // 400

	        return ResponseEntity.ok(hairAssistanceService.save(hairAssistance));
	    }

	    /**
	     * Actualizar una cita existente
	     * PUT http://localhost:8085/api/hair-assistances
	     */
	    @PutMapping("/hair-assistances")
	    public ResponseEntity<HairAssistance> update(@RequestBody HairAssistance hairAssistance){
	        if (hairAssistance.getId() == null)
	            return ResponseEntity.badRequest().build(); // 400

	        return ResponseEntity.ok(hairAssistanceService.save(hairAssistance));
	    }

	    @DeleteMapping("/hair-assistances/{id}")
	    public ResponseEntity<Void> deleteById(@PathVariable Long id){
	        boolean result = hairAssistanceService.deleteById(id);
	        if(result)
	            return ResponseEntity.noContent().build();
	        else
	            return ResponseEntity.internalServerError().build();
	    }
}
