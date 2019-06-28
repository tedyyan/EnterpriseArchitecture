package lab4.prob2.domain.sub2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nameString;
	
	
	
	public Publisher(String name) {
		this.nameString = name;
	}

	
}
