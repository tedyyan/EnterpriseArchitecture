package lab4.prob2.domain.sub4;

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
        
        
		
		//---------------------------d-----------------------------------
		em.getTransaction().begin();
		lab4.prob2.domain.sub4.Reservation flight1 = new lab4.prob2.domain.sub4.Reservation("12");
		lab4.prob2.domain.sub4.Reservation flight2 = new lab4.prob2.domain.sub4.Reservation("32");
		Customer passenger = new Customer("Fu Jing");
		passenger.addReservation(flight1);
		passenger.addReservation(flight2);
		
		em.persist(passenger);
		em.getTransaction().commit();
		

		em.close();
    }
}
