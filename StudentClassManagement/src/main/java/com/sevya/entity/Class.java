package com.sevya.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "class")
@Setter
@Getter
@NoArgsConstructor
public class Class extends BaseModel{
	
	@Column(length = 30)
	private String name;
		
	@Column(length = 4)
	private String code;
	
	
	//***associations***
	@OneToMany(mappedBy = "standard", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Student> student;
	
	
	public Class(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	
}
