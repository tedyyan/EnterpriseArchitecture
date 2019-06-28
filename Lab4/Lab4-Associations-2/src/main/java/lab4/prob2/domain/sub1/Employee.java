package lab4.prob2.domain.sub1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;	
import lombok.NoArgsConstructor;

@Data
@Entity(name="sub1Employee")
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	Department department;
	

}
