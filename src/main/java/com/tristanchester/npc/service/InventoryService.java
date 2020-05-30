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
	
	public Set<Item> convertToItemSet(Iterable<Item> iterableItem) {
		Set<Item> itemSet = new HashSet<Item>();
		for (Item item : iterableItem) {
			itemSet.add(item);
		}
		return itemSet;
	}
	
	public int calculateNetWorth(Set<Item> items) {
		int worth = 0; //Inventory Initial Value
		for (Item item : items) {
			worth += item.getCost();
		}
		return worth;
	}
	
}
/*
 *  Inventory Initialization:
 *    TODO: 
 *    		2. write system for weight calculation
 *    		3. write system for inventory weight 
 *    		   and physical space (size) limits
 *    		Use Iterable<Item> for these?
 */

	





















