package com.tristanchester.npc.entity;

//import java.util.Set;

import javax.persistence.Entity;
//import javax.persistence.CascadeType;
//import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

import com.tristanchester.npc.util.PlayerLevel;

@Entity
public class PlayerCharacter {

	private Long id;
	private String name;
	private int age;
//	private Location currentLocation; 
	private PlayerLevel playerLevel; //TODO Populate PlayerLevel Enum
//  private Inventory playerInventory;
//	private Alignment playerAlignment; //TODO Create player alignment Enum + populate
	
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
	
	public PlayerLevel getPlayerLeve() {
		return playerLevel;
	}
	
	public void setPlayerLevel(PlayerLevel playerLevel) {
		this.playerLevel= playerLevel;
	}
	
}
/*  
 *Player Character Properties:
 *
 *  Name: String
 *  PlayerLevel: Enum
 *  Age: int
 *  Homeland: make new obj? or make String
 *  Current Location: String (or new Object) //TODO make Location object class
 *  Alignment: Enum
 *  DiploLevel: Enum (Diplomatic Relations with NPC)
 *  Stats:
 *    Strength: int
 *    Stamina: int
 *    Dexterity: int
 *    Intellect: int
 *    Charisma: int
 *  PlayerInventory: Make Inventory object class (properties below)
 *	
 */
 

/* 
 *Inventory Object Properties(?):
 * 	Items: Set<Item>
 * 	TotalWeight: int
 *  TotalWorth: int
 *  Size: int
 * 
 */
