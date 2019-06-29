package lab4.prob2.domain.sub4;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lab4.prob2.domain.sub4.Customer;

public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        
        //Create a Unidirectional OneToMany association between Customer and
        //Reservation using annotations.

        //
		//---------------------------d-----------------------------------
		em.getTransaction().begin();
		Reservation flight1 = new Reservation("12");
		Reservation flight2 = new Reservation("32");
		Customer cumstomer = new Customer("Fu Jing");
		cumstomer.addReservation(flight1);
		cumstomer.addReservation(flight2);
		
		em.persist(cumstomer);
		em.getTransaction().commit();
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, 1);
		System.out.println(customer.getReservations().get(0).getNumber());
		System.out.println(customer.getReservations().get(1).getNumber());
		em.getTransaction().commit();
		

		em.close();
    }
}
