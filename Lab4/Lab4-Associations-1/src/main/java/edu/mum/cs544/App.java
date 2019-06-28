package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Owner owner = new Owner("Teddy","Beijing 100-1-1");
        em.persist(owner);
        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        car1.setOwner(owner);
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        owner.setAddress("Shanghai 1100110");
        car2.setOwner(owner);
        em.persist(car2);
        
       
        //
        em.getTransaction().commit();
        
        
        em.getTransaction().begin();
        car1=em.find(Car.class,1l);
        System.out.print(car1.getOwner());
        
        em.getTransaction().commit();
        em.close();
        
        
    }
}
