package com.tristanchester.npc.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inventory {
	
	private Long id;
	private int size; //Standard size is 28 "slots", limits total item quantity
	private Set<Item> items; //Renamed from "Contents"
	
	@JsonIgnore //See inventoryService
	private int worth;
	
	@JsonIgnore
	private int weight;
	
	@JsonIgnore
	private Character owner;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Character getOwner() {
		return owner;
	}
	
	public void setOwner(Character owner) {
		this.owner = owner;
	}
	
	//TODO: Consider removing these, perform inventory worth calculations in service
	public int getWorth() {
		return worth;
	}
	//See Above
	public void setWorth(int worth) {
		this.worth = worth;
	}
	
	//TODO: Consider removing, perform inventory weight calculation in service
	public int getWeight() {
		return weight;
	}
	//See Above
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
