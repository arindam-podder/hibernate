package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import com.helper.School;

import lombok.Data;

@Entity
@Data
@Table(name = "STUDENT_WITH_SCHOOL")
public class StudentWithSchool {
	
	@Id
	@Column(name = "S_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
		
	@Column(name = "LAST_NAME")
	private String lastName;
	

	private School school;
	
}
