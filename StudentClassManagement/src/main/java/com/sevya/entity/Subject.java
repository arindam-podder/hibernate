package com.sevya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject" )
@Setter
@Getter
@NoArgsConstructor
public class Subject extends BaseModel {
	
	@Column(length = 20)
	private String name;
	private String code;
	
	public Subject(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	
}
