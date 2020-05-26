package com.tristanchester.npc.entity;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.tristanchester.npc.util.CharacterType;
import com.tristanchester.npc.util.Level;

public class Character {

	private Long id;
	private String name;
	private int age;
	private Location location; 
	private Level level;
	private Inventory inventory; //refer to inventory_id foreign key in character table
	private CharacterType type;
//	private Alignment alignment;
	
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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//Many characters can share one location
	@ManyToOne(cascade = CascadeType.ALL) //TODO allow metaphysics?
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	@OneToOne(mappedBy = "character")
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public CharacterType getType() {
		return type;
	}
	
	public void setType(CharacterType type) {
		this.type = type;
	}
	
}
