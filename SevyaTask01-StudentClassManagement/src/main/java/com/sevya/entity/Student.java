package com.sevya.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Setter
@Getter
@NoArgsConstructor
public class Student extends BaseModel{
	
	@Column(length = 30)
	private String name;
	
	private Integer age;
	
	@Column(length = 1)
	private String gender;
	
	
	private String feedback;		// feedback= good or bad only
	
	//***associations***
	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )	
	@JoinColumn(name = "class_id")
	private Standard standard;  
	
	
	public Student(String name, Integer age, String gender, String feedback) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.feedback = feedback;
		
	}
	
	
}
