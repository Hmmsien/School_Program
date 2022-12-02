package com.itlize.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itlize.hibernate.demo.entity.Course;
import com.itlize.hibernate.demo.entity.CourseRegistration;
import com.itlize.hibernate.demo.entity.Instructor;
import com.itlize.hibernate.demo.entity.InstructorDetail;
import com.itlize.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(CourseRegistration.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {								
			int studentId = 3;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setLastName("He");
			
			// commit the transaction
			session.getTransaction().commit();

			// NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='students@itlize.com'")
				.executeUpdate();
						
			// commit the transaction
			session.getTransaction().commit();

			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
