package com.tristanchester.npc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Location {
	//TODO: Create Location Service and Controller, Consider "storing" all character, items, etc within the specified region?
	
	private Long id;
	private String name;
	private String description;
	private int age;
	private int landSize;
	
	//TODO: Commented out population Getters/setters, perform population calculations in service layer
	@JsonIgnore
	private int populationSize;
	
	@JsonIgnore
	private Character character; //A single location can "contain" many Characters
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getLandSize() {
		return landSize;
	}
	
	public void setLandSize(int landSize) {
		this.landSize = landSize;
	}
	
//	public int getPopulationSize() {
//		return populationSize;
//	}
//	
//	public void setPopulationSize(int populationSize) {
//		this.populationSize = populationSize;
//	}
	
	@OneToMany(mappedBy = "location")
	public Character getCharacter() {
		return character;
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
	
}
