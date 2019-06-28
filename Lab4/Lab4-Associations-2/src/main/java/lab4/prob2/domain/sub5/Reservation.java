package lab4.prob2.domain.sub5;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity(name="sub5Reservation")
@Data
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String number;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Book book;
	
	public Reservation(String number ){
		this.number = number;
	}
}
