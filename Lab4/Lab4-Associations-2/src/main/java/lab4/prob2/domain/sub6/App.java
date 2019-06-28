package lab4.prob2.domain.sub6;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        
        

		
		//---------------------------e-----------------------------------
		em.getTransaction().begin();
		Employee employee = new Employee("12");
		Employee employee2 = new Employee("12");
		Office office = new Office();
		office.addEmployee(employee);
		office.addEmployee(employee2);
		
		em.persist(office);
		em.getTransaction().commit();
		
		
		em.close();
    }
}
