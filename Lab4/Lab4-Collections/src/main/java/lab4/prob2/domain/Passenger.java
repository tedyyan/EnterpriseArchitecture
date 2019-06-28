package lab4.prob2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data

public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nameString;
	String passportNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="passager_id")
	@OrderColumn(name = "sequence")
	List<Flight> flights = new ArrayList<>();
	
	public Passenger(String name, String passport) {
		this.nameString = name;
		this.passportNumber =passport;
	}

	public void addFlight(Flight flight1) {
		this.flights.add(flight1);
		
	}
}
