package lab4.prob2.domain.sub5;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        
        

		
		//---------------------------e-----------------------------------
        //Create a Unidirectional ManyToOne association between Reservation and
        //Book using annotations.
		em.getTransaction().begin();
		lab4.prob2.domain.sub5.Reservation reservation1 = new lab4.prob2.domain.sub5.Reservation("12");
		lab4.prob2.domain.sub5.Reservation reservation2 = new lab4.prob2.domain.sub5.Reservation("32");
		Book book = new Book("Fu Jing","Jacken Li");
		
		reservation1.setBook(book);
		reservation2.setBook(book);
		
		em.persist(reservation1);
		em.persist(reservation2);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Reservation reservation11 = em.find(Reservation.class, 1);
		System.out.println(reservation11.getBook().getName());
		em.getTransaction().commit();
		
		em.close();
    }
}
