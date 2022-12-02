package com.itlize.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itlize.hibernate.demo.entity.Course;
import com.itlize.hibernate.demo.entity.CourseRegistration;
import com.itlize.hibernate.demo.entity.Instructor;
import com.itlize.hibernate.demo.entity.InstructorDetail;
import com.itlize.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(CourseRegistration.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {			
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("jing", "wang", "jing@gmail.com");
		
		// start a transaction
		session.beginTransaction();
		
		// save the student object
		System.out.println("Saving the student...");
		System.out.println(tempStudent);
		session.save(tempStudent);
		
		// commit transaction
		session.getTransaction().commit();
		
		// MY NEW CODE
		
		// find out the student's id: primary key
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		
		// now get a new session and start transaction
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		// retrieve student based on the id: primary key
		System.out.println("\nGetting student with id: " + tempStudent.getId());
		
		Student myStudent = session.get(Student.class, tempStudent.getId());
		
		System.out.println("Get complete: " + myStudent);
		
		// commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
		}
		finally {
		factory.close();
		}


	}
}


