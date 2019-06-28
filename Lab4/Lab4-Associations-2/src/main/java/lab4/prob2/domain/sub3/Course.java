package lab4.prob2.domain.sub3;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nameString;
	String teacher;
	@ManyToMany
	@JoinTable( name="student_course", 
			joinColumns= { @JoinColumn(name = "student_studentid") },
			inverseJoinColumns= { @JoinColumn(name = "course_id") })
	List<Student> students = new ArrayList<>();
	
	public Course(String name, String teacher) {
		this.nameString = name;
		this.teacher = teacher;
	}

	public void addStudent(Student student) {
		this.students.add(student);
		
	}
}
