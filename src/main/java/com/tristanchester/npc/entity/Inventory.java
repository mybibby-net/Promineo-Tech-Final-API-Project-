package com.tristanchester.npc.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inventory {

	private Long id;
	private int size;
	private Set<Item> items; //TODO: Removed unused HashSet import, investigate why a HashSet is a better alternative?
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

	@OneToMany(mappedBy = "inventory", targetEntity = Item.class)
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@OneToOne
	@JoinColumn(name = "ownerId") //look into CascadeType.PERSIST or CascadeType.ALL
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
