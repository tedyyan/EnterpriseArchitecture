package edu.mum.cs544;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Embeddable
public class Payment {
	private String paydate;
	private double amount;

}
