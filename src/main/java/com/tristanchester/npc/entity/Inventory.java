package com.tristanchester.npc.entity;

import java.util.Set;

public class Inventory {

	private int size; //Standard size is 28 "slots"
	private Set<Item> items;
	private String owner; //Equal to Character name
	private int netWorth; //in "gold"
	private int weight; //in lbs
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public Set<Item> getItems() {
		return items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getNetWorth() {
		return netWorth;
	}
	
	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
