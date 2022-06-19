package com.sevya.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_subject_mapper")
@Setter
@Getter
public class StudentSubjectMapper extends BaseModel{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	
	public StudentSubjectMapper() {
		
	}

	public StudentSubjectMapper(Student student, Subject subject) {
		super();
		this.student = student;
		this.subject = subject;
	} 
	
	
	
}
