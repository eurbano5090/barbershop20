package com.enurbano.barbershop.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 40, name = "first_name")
	    private String firstName;

	    @Column(name="last_name")
	    private String lastName;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(name="birth_date")
	    private LocalDate birthDate;

	    @Column(nullable = false, unique = true)
	    private String nss;

	    @Column(nullable = false, unique = true)
	    private String dni;

//	    @JsonIgnore
//	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "direction_id")
	    private Direction direction;

	    public Employee(){}

	    public Employee(Long id, String firstName, String lastName, String email, LocalDate birthDate, String nss, String dni) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.birthDate = birthDate;
	        this.nss = nss;
	        this.dni = dni;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public LocalDate getBirthDate() {
	        return birthDate;
	    }

	    public void setBirthDate(LocalDate birthDate) {
	        this.birthDate = birthDate;
	    }

	    public String getNss() {
	        return nss;
	    }

	    public void setNss(String nss) {
	        this.nss = nss;
	    }

	    public String getDni() {
	        return dni;
	    }

	    public void setDni(String dni) {
	        this.dni = dni;
	    }

	    public Direction getDirection() {
	        return direction;
	    }

	    public void setDirection(Direction direction) {
	        this.direction = direction;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "id=" + id +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", email='" + email + '\'' +
	                ", birthDate=" + birthDate +
	                ", nss='" + nss + '\'' +
	                ", dni='" + dni + '\'' +
	                '}';
	    }
	}