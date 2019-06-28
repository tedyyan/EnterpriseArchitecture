package lab4.prob2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String studentId;
	String name;
	
	public Student(String studentId, String name) {
		this.studentId =studentId;
		this.name = name;
	}
}
