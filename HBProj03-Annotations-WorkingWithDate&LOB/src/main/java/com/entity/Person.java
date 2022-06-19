package com.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "PERSON_DATE_LOB")
public class Person {

	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "P_NAME", length = 30, nullable = false)
	private String name;
	
	@Column(name = "P_LOCATION", length = 50)
	private String location;
	
	@Column(name = "P_DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "P_CURRENT_DATE")
	private LocalDate currentDate;
	
	@Column(name = "P_IMAGE")
	@Lob
	private byte[] image;		//binary file(image,audio etc.)
	
	@Column(name = "P_RESUME")
	@Lob
	private char[] resume;		//text file
	
}
