package lab4.prob2.domain.sub5;

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
        
        

		
		//---------------------------e-----------------------------------
		em.getTransaction().begin();
		lab4.prob2.domain.sub5.Reservation reservation1 = new lab4.prob2.domain.sub5.Reservation("12");
		lab4.prob2.domain.sub5.Reservation reservation2 = new lab4.prob2.domain.sub5.Reservation("32");
		lab4.prob2.domain.sub5.Book book = new lab4.prob2.domain.sub5.Book("Fu Jing","Jacken Li");
		
		reservation1.setBook(book);
		reservation2.setBook(book);
		
		em.persist(reservation1);
		em.persist(reservation2);
		em.getTransaction().commit();
		
		
		em.close();
    }
}
