package com.sevya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exam")
@Setter
@Getter
@NoArgsConstructor
public class Exam extends BaseModel{
	
	@Column(length = 20)
	private String name;
	private String code;
	
	public Exam(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	
	
}
