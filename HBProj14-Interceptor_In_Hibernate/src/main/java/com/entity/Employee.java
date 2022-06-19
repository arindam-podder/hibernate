package com.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_INTERCEPTOR")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EID")
	private Integer id;
	
	@Column(name = "ENAME")
	private String name;
	
	@Column(name = "EROLE")
	private String role;
	
	
	//version and timestamp feature
	@Version
	@Column(name = "UPDATE_COUNT")
	private Integer updationCount;
	
	@CreationTimestamp
	@Column(name = "CREATE_TIME")
	private Timestamp creationTime;
	
	@UpdateTimestamp
	@Column(name = "LAST_UPDATED")
	private Timestamp lastUpdationTime;
	
	
	//extra property for interceptor
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
}







