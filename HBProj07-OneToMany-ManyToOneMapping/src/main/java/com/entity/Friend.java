package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "FRIEND_MTO")
public class Friend {
	@Id
	@Column(name = "F_ID")
	private Integer id;
	
	@Column(name = "F_NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "P_ID")
	private Person person;

}
