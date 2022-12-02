package com.itlize.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CourseRegistration")
public class CourseRegistration {

	// define our fields
	
	// define constructors
	
	// define getter setters
	
	// define tostring
	
	// annotate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="student_id")
	private Student student;
	
	public CourseRegistration() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCouseId() {
		return course;
	}

	public void setCouseId(Course course) {
		this.course = course;
	}

	public Student getstudentId() {
		return student;
	}

	public void setInstructor(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + "]";
	}
}