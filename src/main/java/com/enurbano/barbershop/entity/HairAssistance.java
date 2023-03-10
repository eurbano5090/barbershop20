package com.enurbano.barbershop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hair_assistances")
public class HairAssistance {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private Double price;

	    private Integer duration; // tiempo estimado en minutos

	    public HairAssistance(){}

	    public HairAssistance(Long id, String name, Double price, Integer duration) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	        this.duration = duration;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Double getPrice() {
	        return price;
	    }

	    public void setPrice(Double price) {
	        this.price = price;
	    }

	    public Integer getDuration() {
	        return duration;
	    }

	    public void setDuration(Integer duration) {
	        this.duration = duration;
	    }
}
