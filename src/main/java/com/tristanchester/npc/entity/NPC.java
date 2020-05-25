package com.tristanchester.npc.entity;

import com.tristanchester.npc.util.NpcLevel;

public class NPC {

	private Long id;
	private String name;
	private int age;
	private NpcLevel npcLevel;
	private Location currentLocation;
	private Inventory inventory;
//	private Alignment alignment;
	
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
	
	public NpcLevel getNpcLevel() {
		return npcLevel;
	}
	
	public void setNpcLevel(NpcLevel npcLevel) {
		this.npcLevel = npcLevel;
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInvetory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
/* 
 * NPC Properties: 
 *	
 *	Name: String
 *	NpcLevel: Enum
 *	Homeland: Location object
 *	Current Location: String
 *	Age: int
 *  Stats: //TODO plan logic for Stats and modifiers
 *    Strength: int
 *    Stamina: int
 *    Dexterity: int
 *    Intellect: int
 *    Charisma: int
 * 	Inventory Size: int
 * 	Current Inventory: Set<...>	
 *  Diplo: int (diplomatic relations with player)
 */