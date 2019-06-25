package edu.mum.cs544;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppBook {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        java.util.Date publishdate = new Date();
        Book book1 = new Book("Dream","1231112","Chacle",23.1,publishdate);
        em.persist(book1);

        Book book2 = new Book("World Peace","8129112","Mickle Ugan",12.1,publishdate);
        em.persist(book2);

        Book book3 = new Book("My god","3319112","Benjiman Li",33.1,publishdate);
        em.persist(book3);
        em.getTransaction().commit();
        em.close();
        
        
        //------------------------------------------------------------------
        queryAllbooks();
        
      //------------------------------------------------------------------
        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> carList = query.getResultList();
        int i=0;
    	Book bookupdate = null;
    	Book bookdelete = null;
        for (Book book : carList) {
            if (i==0) {
            	bookupdate =book;
            }
            if (i==1) {
            	bookdelete =book;
            }
            i++;
        }

		bookupdate.setTitle("A new title book");
    	bookupdate.setPrice(123.0);
    	em.persist(bookupdate);
    	em.remove(bookdelete);
        em.getTransaction().commit();
        em.close();
        
      //------------------------------------------------------------------
        queryAllbooks();
        
        
    }
    
    public static void queryAllbooks() {
    	//------------------------------------------------------------------
    	EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> carList = query.getResultList();
        for (Book book : carList) {
            System.out.println(book);
        }
        em.getTransaction().commit();
        em.close();
    }
}
