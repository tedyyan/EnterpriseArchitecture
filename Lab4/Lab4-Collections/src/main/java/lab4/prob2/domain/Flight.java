package lab4.prob2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(name = "fromport")
	String from;
	@Column(name = "toport")
	String to;
	
	String numString;
	
	
	public Flight(String from, String to, String num) {
		this.from = from;
		this.to = to;
		this.numString = num;
	}
}
