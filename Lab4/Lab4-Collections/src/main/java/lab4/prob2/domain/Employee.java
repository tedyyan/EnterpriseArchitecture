package lab4.prob2.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String name;
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	Set<Laptop> laptopSet = new HashSet<>();
	
	public void addLaptop(Laptop laptop) {
		laptopSet.add(laptop);
		laptop.setEmployee(this);
	}
}
