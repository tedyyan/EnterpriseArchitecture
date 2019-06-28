package lab4.prob2.domain.sub6;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name="sub6Employee")
@Data
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String name;
		
		@ManyToOne
		Office office;
		
		public Employee(String name) {
			this.name = name;
		}
}
