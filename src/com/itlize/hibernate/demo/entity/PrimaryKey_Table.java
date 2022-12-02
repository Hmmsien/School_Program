package com.itlize.hibernate.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

public class PrimaryKey_Table {
	@TableGenerator(name = "PK_SEQ", 
			 table = "SEQUENCE_TABLE", 
			                pkColumnName  = "SEQUENCE_NAME", 
			                valueColumnName  = "SEQUENCE_COUNT") 
			 
			 @Id 
			 @GeneratedValue(strategy =GenerationType.TABLE,generator="PK_SEQ") 
			 private Long id; 
			 

}
