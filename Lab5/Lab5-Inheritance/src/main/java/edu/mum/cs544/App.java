package edu.mum.cs544;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Order order = new Order();
        order.setDate(Date.valueOf("2019-1-1"));
        Customer customer = new Customer();
        customer.setFirstName("Frank");
        customer.setLastName("Zhou");
        order.setCustomer(customer);
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setQuantity(100);
        
        CD cd = new CD();
        cd.setArtist("Artist A");
        cd.setName("CDName");
//        Product product = new Product();
//        product.setName("product1");
//        product.setDescription("product1 description");
        
		orderLine1.setProduct(cd );
		
		//-----------------------------------------------------
        OrderLine orderLine2 = new OrderLine();
        orderLine2.setQuantity(210);
        
//        Product product2 = new Product();
//        product2.setName("product1");
//        product2.setDescription("product1 description");

        DVD dvd = new DVD();
        dvd.setGenre("genre 1");
        dvd.setName("DVDName");
		orderLine2.setProduct(dvd );
		
		order.addOrderLine(orderLine1);
		order.addOrderLine(orderLine2);
        em.persist(order);
        // Create new instance of Car and set values in it
        
        
        em.getTransaction().commit();
        
        
        em.getTransaction().begin();
//        Order order1 = em.find(Order.class, 1l);
//        System.out.println(order1.getCustomer().getFirstName());
//        System.out.println(order1.getOrderLines().get(0).getQuantity());
//        System.out.println(order1.getOrderLines().get(0).getProduct().getName());
//        System.out.println(order1.getOrderLines().get(1).getQuantity());
//        System.out.println(order1.getOrderLines().get(1).getProduct().getName());
//        
        //Print result
//        Frank
//        100
//        product1
//        210
//        product1
        
        
        Order order1 = em.find(Order.class, 1l);
        System.out.println(order1.getCustomer().getFirstName());
        System.out.println(order1.getOrderLines().get(0).getQuantity());
        System.out.println(order1.getOrderLines().get(0).getProduct().getName());
        System.out.println(order1.getOrderLines().get(1).getQuantity());
        System.out.println(order1.getOrderLines().get(1).getProduct().getName());
        
        em.getTransaction().commit();
        
      //Print result
//        Frank
//        100
//        CDName
//        210
//        DVDName
        em.close();
        
        
    }
}
