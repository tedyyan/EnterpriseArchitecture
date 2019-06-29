package lab4.prob2.domain.sub2;

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
        
       
		//Create an Optional Unidirectional ManyToOne association between Book and
        //Publisher using annotations and without using NULL fields in the database
		
		//----------------------------b---------------------------------
		em.getTransaction().begin();
		Book book1 = new Book("One Dream","Zhou Xiang");
		Book book2 = new Book("A Leaf","Ming Zhi");
		Publisher  publisher = new Publisher("Times");
		book1.setPublisher(publisher);
		book2.setPublisher(publisher);
		em.persist(book1);
		em.persist(book2);
		
		Publisher publisher2 = em.find(Publisher.class, 1);
		System.out.println(publisher2.getNameString());
		
		em.getTransaction().commit();
		
		
		em.close();
    }
}
