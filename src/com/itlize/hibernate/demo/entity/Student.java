package com.itlize.hibernate.demo.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//Example of Persisting an Object
@Entity
@Table(name="student")
public class Student {

	//primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
    @Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "student",  cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	private Set<CourseRegistration> registrations = new HashSet<>();
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<CourseRegistration> getRegistreation() {
		return registrations;
	}

	public void setRegistreation(Set<CourseRegistration> registrations) {
		this.registrations = registrations;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}




