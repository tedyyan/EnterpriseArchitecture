package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Owner {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String name;
	private String address;
	
	public Owner(String name, String address) {
		this.name = name;
		this.address = name;
	}
	
	@Override
	public String toString() {
		return "Owner: "+this.name + " at " + this.address;
	}
}

