package lab4.prob2.domain.sub6;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        
        

		
		//---------------------------f-----------------------------------
        //Create a Bidirectional ManyToOne association between Employee and Office
        //using annotations
		em.getTransaction().begin();
		Employee employee = new Employee("12");
		Employee employee2 = new Employee("13");
		Office office = new Office();
		office.addEmployee(employee);
		office.addEmployee(employee2);
		
		em.persist(office);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Office o1 = em.find(Office.class, 1);
		System.out.println(o1.getEmployees().get(0).getName());
		System.out.println(o1.getEmployees().get(1).getName());
		em.getTransaction().commit();
		
		em.close();
    }
}
