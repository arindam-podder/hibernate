package com.sevya.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "standard")
@Setter
@Getter
@NoArgsConstructor
public class Standard extends BaseModel{
	
	@Column(length = 30)
	private String name;
		
	@Column(length = 4)
	private String code;
	
	
	//***associations***
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	@JoinColumn(name = "class_id")
	private List<Student> students;
	
	
	public Standard(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	
}
