package lab4.prob2.domain.sub4;

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

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nameString;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="passager_id")
	@OrderColumn(name = "sequence")
	List<Reservation> reservations = new ArrayList<>();
	
	public Customer(String name) {
		this.nameString = name;
	}

	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
		
	}
}
