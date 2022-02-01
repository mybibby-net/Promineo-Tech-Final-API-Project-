package com.tristanchester.npc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Item {

	private Long id;
	private String name;
	private String description;
	private int cost;
	private int weight;
	private int healthModifier;
	private int staminaModifier;
	private int strengthModifier;
	private int intellectModifier;
	private int charismaModifier;

	@JsonIgnore
	private Inventory inventory;

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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventoryId")
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) { 
		this.inventory = inventory; 
	}

	public int getHealthModifier() {
		return healthModifier;
	}

	public void setHealthModifier(int healthModifier) {
		this.healthModifier = healthModifier;
	}

	public int getStaminaModifier() {
		return staminaModifier;
	}

	public void setStaminaModifier(int staminaModifier) {
		this.staminaModifier = staminaModifier;
	}

	public int getStrengthModifier() {
		return strengthModifier;
	}

	public void setStrengthModifier(int strengthModifier) {
		this.strengthModifier = strengthModifier;
	}

	public int getIntellectModifier() {
		return intellectModifier;
	}

	public void setIntellectModifier(int intellectModifier) {
		this.intellectModifier = intellectModifier;
	}

	public int getCharismaModifier() {
		return charismaModifier;
	}

	public void setCharismaModifier(int charismaModifier) {
		this.charismaModifier = charismaModifier;
	}

}