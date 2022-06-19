package com.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "PERSON_OTM")
public class Person {
	@Id
	@Column(name = "P_ID")
	private Integer id;
	
	@Column(name = "P_NAME")
	private String name;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JoinTable(name = "P_F_JOIN")
	private List<Friend> friends;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	

}
