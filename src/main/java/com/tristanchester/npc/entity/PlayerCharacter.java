package com.tristanchester.npc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.tristanchester.npc.util.PlayerLevel;

@Entity
public class PlayerCharacter {

	private Long id;
	private String name;
//  private Homeland homeland;
	private String homeland; //TODO Either make Homeland an Object class or store as String OR Enum
	private PlayerLevel playerLevel; //TODO create PlayerLevel Enum
//  private Inventory playerInventory;
	
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
