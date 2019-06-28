package lab4.prob2.domain.sub1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String name;
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	@OrderColumn(name="sequence")
	List<Employee> employees = new ArrayList<>();
	
	public void addLaptop(Employee laptop) {
		employees.add(laptop);
		laptop.setDepartment(this);
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
		employee.setDepartment(this);
		
	}
}
