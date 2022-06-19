package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
//@Table(name = "student")
public class Student {
	@Id
	private Integer id;
	private String name;
	private LocalDate dob;
	private String location;
	
}
