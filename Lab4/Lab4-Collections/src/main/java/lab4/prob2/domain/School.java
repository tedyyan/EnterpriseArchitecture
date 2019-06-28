package lab4.prob2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data

public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nameString;
	String address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="school_id")
	//@OrderColumn(name = "sequence")
	@MapKey(name = "studentId")
	Map<String,Student> students = new HashMap<>();
	
	public School(String name, String addr) {
		this.nameString = name;
		this.address = addr;
	}

	public void addStudent(Student student) {
		this.students.put(student.getStudentId(),student);
		
	}
}
