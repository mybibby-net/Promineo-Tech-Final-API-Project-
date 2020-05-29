package com.tristanchester.npc.entity;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Inventory {
	
	private Long id;
	private int size; //Standard size is 28 "slots"
	private Set<Item> contents; //Renamed from "items"
	private int worth;
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
	
	public Set<Item> getContents() {
		return contents;
	}
	
	public void setContents(Set<Item> contents) {
		this.contents = contents;
	}
	
	public Character getOwner() {
		return owner;
	}
	
	public void setOwner(Character owner) {
		this.owner = owner;
	}
	
	public int getWorth() {
		return worth;
	}
	
	public void setWorth(int worth) {
		this.worth = worth;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
