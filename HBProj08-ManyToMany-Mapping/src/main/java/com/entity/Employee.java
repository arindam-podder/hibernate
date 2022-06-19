package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_MTM")
public class Employee {

	@Id
	@Column(name =  "E_ID")
	private Integer id;
	
	@Column(name = "E_NAME")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "EMP_PROJ_JOIN", joinColumns =  {@JoinColumn(name = "fk_emp") } , inverseJoinColumns = {@JoinColumn(name = "fk_proj")})
	private List<Project> projects;
		
}
