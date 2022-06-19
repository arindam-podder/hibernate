package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PROJECT_MTM")
public class Project {
	
	@Id
	@Column(name = "P_ID")
	private Integer id;

	@Column(name = "P_NAME")
	private String name;
	
	@ManyToMany(mappedBy = "projects" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> employees;
	
}
