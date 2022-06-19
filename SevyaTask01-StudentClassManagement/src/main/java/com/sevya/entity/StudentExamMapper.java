package com.sevya.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_exam_mapper")
@Setter
@Getter
public class StudentExamMapper extends BaseModel{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_id")
	private Exam exam;
	
	public StudentExamMapper() {
		
	}

	public StudentExamMapper(Student student, Exam exam) {
		super();
		this.student = student;
		this.exam = exam;
	}
	
	
	
}
