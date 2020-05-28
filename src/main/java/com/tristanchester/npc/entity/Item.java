package com.tristanchester.npc.entity;

public class Item {
	
	private Long id;
	private String name;
	private String description;
//	private int statModifier; //TODO: Create Stat and Modifier system
	private int cost;
	private int weight;
	
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
	
//	public int getStatModifier() {
//		return statModifier;
//	}
//	
//	public void setStatModifier(int statModifier) {
//		this.statModifier = statModifier;
//	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
