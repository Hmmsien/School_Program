package com.itlize.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itlize.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create 5 student object
			System.out.println("Creating 5 student object...");
			Student tempStudent1 = new Student("Bogac", "Sabuncu", "111@gmail.com");
			Student tempStudent2 = new Student("Xuanwen", "Zheng", "222@gmail.com");
			Student tempStudent3 = new Student("Bochao", "Wang", "333@gmail.com");
			Student tempStudent4 = new Student("example","Doe","444@gmail.com");
			Student tempStudent5 = new Student("Daffy","example","555@gmail.com");
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			session.save(tempStudent5);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
