package com.entity;

import java.util.Date;

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
	private Integer id;
	
	//for holding record insertion time
	@CreationTimestamp	 
	private Date creationDate;
	
	//for holding record lastupdation time
	@UpdateTimestamp	 
	private Date lastUpdated;
	
}
