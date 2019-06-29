package edu.mum.cs544;

import java.awt.PopupMenu;
import java.awt.event.PaintEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Appointment appointment = new Appointment();
        appointment.setAppdate("app 2019-12-1");
        Patient patient = new Patient();
        patient.setName("Patient Jack");
        patient.setCity("Fairfeild");
        patient.setStreet("N1000");
        patient.setZip("56657");
        
        Payment payment = new Payment();
        payment.setAmount(1001.12);
        payment.setPaydate("2019-3-1");
        Doctor doctor = new Doctor();
        doctor.setFirstname("Dr A");
        doctor.setLastname("Jim");
        doctor.setDoctortype("Eye Doctor");
        
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setPayment(payment);
        em.persist(appointment);
        //
        em.getTransaction().commit();
        
        
        em.getTransaction().begin();
        Appointment appointment2=em.find(Appointment.class,1l);
        System.out.println(appointment2.getAppdate());
        System.out.println(appointment2.getDoctor().getDoctortype());
        System.out.println(appointment2.getPayment().getAmount());
        
        em.getTransaction().commit();
        em.close();
        
        
    }
}
