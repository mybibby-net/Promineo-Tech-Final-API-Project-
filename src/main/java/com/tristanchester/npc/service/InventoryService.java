package com.tristanchester.npc.service;

import java.util.Set;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tristanchester.npc.entity.Character;
import com.tristanchester.npc.entity.Inventory;
import com.tristanchester.npc.entity.Item;
import com.tristanchester.npc.repository.CharacterRepo;
import com.tristanchester.npc.repository.InventoryRepo;
import com.tristanchester.npc.repository.ItemRepo;

@Service
public class InventoryService {

	private static final Logger logger = LogManager.getLogger(InventoryService.class);
	private final int inventorySize = 28;
	
	@Autowired
	private InventoryRepo repo;
	
	@Autowired
	private CharacterRepo characterRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	//Initializing inventory with base values, removed Set<Item> param
	public Inventory initializeNewEmptyInventory(Long ownerId) {
		Inventory inventory = new Inventory();
		inventory.setOwner(
				characterRepo.findOne(ownerId)
				);
		inventory.setSize(inventorySize); //28 as default size, think "slots"
//TODO: Needed? Probably not. use setItems() to update/add items elsewhere?
//		inventory.setItems(null); 
		return inventory;
	}
	
	public int getItemQuantity(Inventory inventory) {
		
		return 0;
	}
	
	public Inventory submitNewInventory(Set<Long> itemIds, Long ownerId) {
		try {
			Inventory inventory = initializeNewEmptyInventory(ownerId);
			return repo.save(inventory);
		} catch (Exception e) {
			logger.error(
					"Exception occured while trying to create inventory for character with id: " + ownerId, e
					);
			throw e;
		}
	}
	
	//Updating/adding use setItems() ?
	public void addSingleItemToInventory(Inventory inventory, Long itemId) {
		if (inventory.getSize() < 28) {
			try {
				inventory.setItem(
						itemRepo.findOne(itemId)
						);
			} catch (Exception e) {
				
			}
		}
		
	}
	
	public void addMultipleItemsToInventory() {
		
	}
	
	public Set<Item> convertToItemSet(Iterable<Item> iterableItem) {
		Set<Item> itemSet = new HashSet<Item>();
		for (Item item : iterableItem) {
			itemSet.add(item);
		}
		return itemSet;
	}
	
}
/*
 *  Inventory Initialization:
 *    1. Method to take items and convert to set for storage in inventory object
 *    
 *    TODO: 
 *    		1. write system for worth calculation
 *    		2. write system for weight calculation
 *    		3. write system for inventory weight 
 *    		   and physical space (size) limits
 *    		Use Iterable<Item> for these?
 */
 //TODO: Idea for later: Write a rudimentary skill + skill level system instead of (or paired with) current Enum sytem
	





















