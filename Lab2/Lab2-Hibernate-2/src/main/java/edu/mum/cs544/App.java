package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("simpsons");
        		
        queryAndPrintStudent() ;
        
        //--------------------------------------------------------------
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Students stu = new Students();
        stu.setName("Jordan");
        stu.setPassword("hello");
        stu.setEmail("mike@mum.edu");
        em.persist(stu);
        em.getTransaction().commit();
        em.close();
        
        //--------------------------------------------------------------
        queryAndPrintStudent() ;
        
    }
    
    public static void queryAndPrintStudent() {
    	 EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         
         // retieve all cars
         TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
         List<Students> studentList = query.getResultList();
         for (Students student : studentList) {
             System.out.println("name= " + student.getName());
         }
         em.getTransaction().commit();
         em.close();
    }
}
