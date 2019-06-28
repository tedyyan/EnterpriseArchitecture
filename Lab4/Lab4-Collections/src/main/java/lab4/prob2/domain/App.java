package lab4.prob2.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Employee employee = new Employee();
        employee.setName("Frank");

        Laptop laptop = new Laptop();
        laptop.setType("abc");
        laptop.setSn(1235);
		employee.addLaptop(laptop);

		em.persist(employee);
		em.getTransaction().commit();
		
		//--------------------------------------------------------------
		em.getTransaction().begin();
		Flight flight1 = new Flight("Beijing","Chicargo","UA122");
		Flight flight2 = new Flight("NewYork","Chicargo","AU111");
		Passenger passenger = new Passenger("Fu Jing", "CH1121221");
		passenger.addFlight(flight1);
		passenger.addFlight(flight2);
		
		em.persist(passenger);
		em.getTransaction().commit();
		
		
		//--------------------------------------------------------------
		em.getTransaction().begin();
		School school = new School("MUM", "Fairfeild N 1000");
		Student student1 = new Student("121", "Jack Chen");
		Student student2 = new Student("122", "Frank Zhou");
		school.addStudent(student1 );
		school.addStudent(student2 );
		
		em.persist(school);
		em.getTransaction().commit();
		
		
		em.close();
    }
}
