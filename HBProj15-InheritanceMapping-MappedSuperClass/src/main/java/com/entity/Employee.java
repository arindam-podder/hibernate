package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.inheritancemapping.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "EMPLOYEE_IM")
public class Employee extends Person{
	
	@Column(name = "JOB_ROLE")
	private String jobRole;
	
}
