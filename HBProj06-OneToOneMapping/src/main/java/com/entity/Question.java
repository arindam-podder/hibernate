package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "QUESTION_OTO")
public class Question {
	
	@Id
	@Column(name = "QUESTION_ID")
	private Integer questionId;
	
	@Column(name = "QUESTION")
	private String question;
	
	@OneToOne
	@JoinColumn(name = "A_ID")
	private Answer answer;
	
}
