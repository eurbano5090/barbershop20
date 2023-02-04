package com.enurbano.barbershop.entity;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private Integer duration; // tiempo real en minutos

    @Column(length = 400)
    private String description;

    // asociaciones: OneToOne, OneToMany, ManyToOne, ManyToMany

    // cliente
    // @JsonIgnore // ignora el customer por completo
    @JsonIgnoreProperties(value = {"appointments"}) // ignora atributos específicos del customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // servicio
    @ManyToOne
    @JoinColumn(name = "hair_assistance_id")
    private HairAssistance hairAssistance;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    // constructores

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime date, Integer duration, String description) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.description = description;
    }

    // métodos (getter, setter, demás)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HairAssistance getHairAssistance() {
        return hairAssistance;
    }

    public void setHairAssistance(HairAssistance hairAssistance) {
        this.hairAssistance = hairAssistance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", duration=" + duration +
                '}';
    }}