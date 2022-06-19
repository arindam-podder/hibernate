package com.entity;

import javax.persistence.Entity;
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
@Table(name = "quality_rating")
public class QualityRating extends BaseModel{
	
	private Integer technicalKnowwledge;
	private Integer performance;
	private Integer teamwork;
	private Integer leadership;
	private Integer communication;
	
	
	
}
