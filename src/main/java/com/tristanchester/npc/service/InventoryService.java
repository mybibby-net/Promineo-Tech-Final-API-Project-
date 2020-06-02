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
	
	@Autowired
	private InventoryRepo repo;
	
	@Autowired
	private CharacterRepo characterRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	//TODO: consider prototyping a combination of initialization and submission hybrid method for create of new inventories?
	//Call for POST Sets default values, associates character, doesn't set times.
	public Inventory createNewInventory(Long ownerId) {
		Inventory inventory = new Inventory();
		inventory.setOwner(
				characterRepo.findOne(ownerId));
		inventory.setSize(28); //28 as default size, think "slots"
		inventory.setWorth(0);
		inventory.setWeight(0);
		return repo.save(inventory);
	}

//	TODO: uncomment if new method syntax fails
	public Inventory addItems(Set<Long> itemIds, Long ownerId) throws Exception {
		// Call for PUT Takes character inventory size int, checks if it's lower than the overall size of the inventory (default 28),
		// then allows operation if meets condition, changed from if to while
		if (itemIds.size() < characterRepo.findOne(ownerId).getInventory().getSize()) {
			try {
				Character owner = characterRepo.findOne(ownerId);
				Inventory originalInventory = owner.getInventory();
				originalInventory.setItems(
						convertItemsToSet(itemRepo.findAll(itemIds)));
				return originalInventory;
			} catch (Exception e) {
				logger.error(
						"Unable to add items to inventory with id: " + ownerId, e);
				throw new Exception("Unable to add to inventory");
			}

		} else {
			return null; //TODO: cross fingers and hope this works
		}
	}

	public Set<Item> convertItemsToSet(Iterable<Item> iterableItem) {
		Set<Item> itemSet = new HashSet<Item>();
		for (Item item : iterableItem) {
			itemSet.add(item);
		}
		return itemSet;
	}
	//Takes inventory, calls getItems() to retrieve all items, then calls size() to count all items and returns the number
	public int getItemQuantity(Inventory inventory) { return inventory.getItems().size(); }

	//TODO: Consider using Charisma as a discount enum
	public int calculateNetWorth(Set<Item> items) {
		int worth = 0; //Inventory worth Initial Value
		for (Item item : items) {
			worth += item.getCost();
		}
		return worth;
	}

	//Used to shorten conditionals, returns remaining space (out of maximum of 28) as int
	public int getSpaceRemaining(Inventory inventory) {
		return inventory.getSize() - inventory.getItems().size();
	}

}

	





















