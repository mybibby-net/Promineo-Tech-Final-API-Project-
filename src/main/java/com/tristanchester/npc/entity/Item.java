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
	private int statModifier;

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
	
	public int getStatModifier() { return statModifier; } //TODO: Add stat system to ItemService

	public void setStatModifier(int statModifier) { this.statModifier = statModifier; }
	
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
	public Inventory getInventory() { return inventory; }

	public void setInventory(Inventory inventory) { this.inventory = inventory; }

}
//TODO:
// Illegal attempt to map a non collection as a @OneToMany, @ManyToMany or @CollectionOfElements:
// 	com.tristanchester.npc.entity.Item.inventory