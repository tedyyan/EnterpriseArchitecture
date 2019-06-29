package lab4.prob2.domain.sub3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(mappedBy = "students", 	cascade = CascadeType.ALL)
	List<Course> courses = new ArrayList<>();
	
	public void addCourses(Course course) {
		this.courses.add(course);
	}
}
