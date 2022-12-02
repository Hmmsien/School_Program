package com.itlize.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itlize.hibernate.demo.entity.Course;
import com.itlize.hibernate.demo.entity.CourseRegistration;
import com.itlize.hibernate.demo.entity.Instructor;
import com.itlize.hibernate.demo.entity.InstructorDetail;
import com.itlize.hibernate.demo.entity.Student;

public class UpdateCourseDemo {
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
			int CourseId = 3;
			int instructorId = 2;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve Course based on the id: primary key
			System.out.println("\nGetting Course with id: " + CourseId);
			
			Course myCourse = session.get(Course.class, CourseId);
			Instructor myInstructor = session.get(Instructor.class, instructorId);
			
			System.out.println("Updating Course...");
			myCourse.setInstructor(myInstructor);
			
			// commit the transaction
			session.getTransaction().commit();


			int CourseId2 = 1;
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve Course based on the id: primary key
			System.out.println("\nGetting Course with id: " + CourseId2);
			
			Course course2 = session.get(Course.class, CourseId2);
			
			System.out.println("Updating Course...");
			course2.setTitle("Java");;
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
