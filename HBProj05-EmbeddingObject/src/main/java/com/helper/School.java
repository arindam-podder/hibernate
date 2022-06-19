package com.helper;
 
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
 
import lombok.Data;
 
@Embeddable
@Data
public class School {
 
 	@Column(name = "SCHOOL_NAME")
 	private String schoolName;
  	
  	@Column(name = "SCHOOL_LOCATION")
 	private String schoolLocation;
 	
}
