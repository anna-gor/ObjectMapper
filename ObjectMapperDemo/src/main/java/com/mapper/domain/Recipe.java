package com.mapper.domain;

import java.util.List;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table
@Data
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int complexity;
	
	private String kitchenTime;
	
	private String totalTime;
	

	@OneToMany(cascade = CascadeType.ALL)
    private	List<Step> cooking;

	//@ManyToMany(cascade=CascadeType.ALL)
	@ManyToMany(cascade=CascadeType.MERGE)
	private	List<Ingredient> ingredients;

	private String title;
	private String category;


}
