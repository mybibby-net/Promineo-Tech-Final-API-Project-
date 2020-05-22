package com.tristanchester.npc.entity;

public class Item {
	
	private Long id;
	private String name;
	private String itemDescription;
	private int statModifier;
	private int itemCost;
	//private int itemQuantity; //TODO add to inventory class
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public int getStatModifier() {
		return statModifier;
	}
	
	public void setStatModifier(int statModifier) {
		this.statModifier = statModifier;
	}
	
	public int getItemCost() {
		return itemCost;
	}
	
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}
	
}
/* 
 * Item Properties:
 * 	
 * Name: String
 * Description: String
 * StatModifier: int
 * Cost: int
 * 
 */