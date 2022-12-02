package com.itlize.hibernate.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity 
public class PK_Sequence implements Serializable { 
   private static final long serialVersionUID = 1L; 
   @SequenceGenerator(name="PK_SEQ_TBL",sequenceName="PK_SEQ_NAME") 
   @Id 
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="PK_SEQ_TBL") 
   private Long id; 
// Getters and Setters 



}
