package com.sevya.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" , nullable = false, updatable = false)
	private Integer id;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(columnDefinition="tinyint(1) default 1")	
	private boolean isActive=true;
	
	//time-stamping feature
	@CreationTimestamp
	@Column(name = "creation_time")	
	private Timestamp creationTime;
		
	@UpdateTimestamp
	@Column(name = "last_updated")	
	private Timestamp lastUpdationTime;

}
