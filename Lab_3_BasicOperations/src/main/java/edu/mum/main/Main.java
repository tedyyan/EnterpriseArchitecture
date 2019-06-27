package edu.mum.main;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		UserService userservice = (UserService) applicationContext.getBean("userServiceImpl");
		User user = new User();
		user.setFirstName("John");
		user.setAdmin(false);
		user.setEmail("aa@mum.edu");
		user.setLastLogin(new Date());
		user.setLastName("Doe");
		userservice.save(user);

		//org.hibernate.StaleObjectStateException
		//userservice.update(user);
		
		User r = userservice.findByEmail("aa@mum.edu");
		System.out.println("********* User ************");
		System.out.println(""+r.getFirstName() +" "+ r.getLastName());
		
		r.setRating(100);
		userservice.update(r);

		System.out.println("before flush");
		//userservice.flush();
		System.out.println("after flush "+r.getId());
		userservice.delete(1l);
		System.out.println("after update");
		
		
		
	}

}