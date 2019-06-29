package edu.mum.cs544;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Appointment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String appdate;
	
	
	@Embedded	
	private Payment payment;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient")
	private Patient patient;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctor")
	private Doctor doctor;

}
