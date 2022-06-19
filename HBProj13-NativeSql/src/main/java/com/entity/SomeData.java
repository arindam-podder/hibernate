package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DATA_FOR_HQL")
public class SomeData {
	@Id
	private Integer id;
	
	private String name;

	private Integer age;
	
	private String location;
	
	
}
