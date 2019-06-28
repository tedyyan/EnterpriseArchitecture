package lab4.prob2.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String type;
	Integer sn;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	Employee employee;
	
	@Override
	public  int hashCode() {
		return sn;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other==null) return false;
		if (other instanceof Laptop) {
			Laptop lap = (Laptop) other;
			return lap.sn == this.sn;
		}else {
			return false;
		}
	}
}
