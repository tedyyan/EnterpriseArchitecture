package lab4.prob2.domain.sub1;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lab4.prob2.domain.sub1.Department;
import lab4.prob2.domain.sub1.Employee;

public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        
        //--------------------------a---------------------------------
        //Create a Bidirectional OneToMany association between Department and
        //Employee using annotations
        
        em.getTransaction().begin();
        
        Department department = new Department();
        department.setName("MUM Compro");

        Employee employee = new Employee();
        employee.setName("James Zhou");
        Employee employee1 = new Employee();
        employee1.setName("Jack Ming");
        
        department.addEmployee(employee);
        department.addEmployee(employee1);
        
        
		em.persist(department);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Employee e1 = em.find(Employee.class, 1);
		System.out.println(e1.getDepartment().getName());
		em.getTransaction().commit();
		
		
		em.close();
    }
}
