package com.enurbano.barbershop.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="custmers")
public class Customer {

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

	    // asociaciones
	    // por defecto las asociaciones many son lazy
	    @OneToMany(mappedBy = "customer")
	    private List<Appointment> appointments = new ArrayList<>();

		public Customer() {
			super();
		}

		public Customer(Long id, String firstName, String lastName, String email, LocalDate birthDate) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.birthDate = birthDate;
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

		public List<Appointment> getAppointments() {
			return appointments;
		}

		public void setAppointments(List<Appointment> appointments) {
			this.appointments = appointments;
		}
	
	    
	    
}
