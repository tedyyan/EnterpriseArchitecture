package lab4.prob2.domain.sub3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lab4.prob2.domain.sub1.Department;
import lab4.prob2.domain.sub1.Employee;
import lab4.prob2.domain.sub2.Book;
import lab4.prob2.domain.sub2.Publisher;
import lab4.prob2.domain.sub3.Course;
import lab4.prob2.domain.sub3.Student;
import lab4.prob2.domain.sub4.Customer;

public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        
       
		
		//---------------------------c-------------------------------
		em.getTransaction().begin();
		Student student1 = new Student("12333", "Jack Chen");
		Student student2 = new Student("12333", "Frank Wu");
		Course course1 = new Course("EA", "Tina");
		Course course2 = new Course("ASD", "Lu");
		course1.addStudent(student1);
		course1.addStudent(student2);
		
		course2.addStudent(student2);
		course2.addStudent(student1);
		em.persist(student1);
		em.persist(student2);
		em.getTransaction().commit();
		
		em.close();
    }
}
