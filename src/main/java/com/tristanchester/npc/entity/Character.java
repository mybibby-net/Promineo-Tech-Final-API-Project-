package com.tristanchester.npc.entity;

import javax.persistence.*;

import com.tristanchester.npc.util.CharacterType;

@Entity
public class Character {

	private Long id;
	private String name;
	private int age;
	private Location location;
	private Inventory inventory;
	private CharacterType type;
	private int health;
	private int strength;
	private int stamina;
	private int intellect;
	private int charisma;

	public Character() {}

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
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public int getIntellect() {
		return intellect;
	}
	
	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}
	
	public int getCharisma() {
		return charisma;
	}
	
	//Modifies item costs, consider prototyping basic selling system
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
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

