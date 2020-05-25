package com.tristanchester.npc.entity;

public class Location {

	private String name;
	private String description;
	private int age;
	private int size;
	private int populationSize;
	
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
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPopulationSize() {
		return populationSize;
	}
	
	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}
	
}
/*
 * Location properties:
 *	 Name: String
 *	 LocationDescription: String
 *	 LocationAge: int
 *	 SizeInKm: int
 */
