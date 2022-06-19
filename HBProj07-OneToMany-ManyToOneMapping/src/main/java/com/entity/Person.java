package com.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PERSON_OTM")
public class Person {
	@Id
	@Column(name = "P_ID")
	private Integer id;
	
	@Column(name = "P_NAME")
	private String name;
	
	@OneToMany(mappedBy = "person")
	//@JoinTable(name = "P_F_JOIN")
	private List<Friend> friends;

}
