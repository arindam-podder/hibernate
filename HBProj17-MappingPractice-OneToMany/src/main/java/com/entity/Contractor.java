package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contractor")
public class Contractor extends BaseModel{
	
	private String name;
	private String address;
	private String role;
	
	//mapping
	@OneToMany(targetEntity = QualityRating.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "contructorId")
	private List<QualityRating> qualityRatings;
}
