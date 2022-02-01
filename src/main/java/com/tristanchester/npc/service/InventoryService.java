package com.tristanchester.npc.service;

import java.util.Set;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Inventory createNewInventory(Set<Long> itemIds, Long ownerId) throws Exception{
		try {
			Inventory inventory = new Inventory();
			inventory.setOwner(
				characterRepo.findOne(ownerId)
			);
			inventory.setItems(
				convertItemsToSet(itemRepo.findAll(itemIds))
			);
			inventory.setSize(28); //28 as default size, think "slots"
			inventory.setWorth(
				calculateNetWorth(inventory.getItems(), characterRepo.findOne(ownerId).getCharisma())
			);
			inventory.setWeight(
				calculateNetWeight(inventory.getItems())
			);
			return repo.save(inventory); 
		} catch (Exception e) {
			logger.error("Exception occurred while trying to create a new inventory for character:" + ownerId, e);
			throw new Exception("Unable to create inventory");
		}
	}

	public Inventory addItems(Set<Long> itemIds, Long ownerId) throws Exception {
		try {
			Inventory originalInventory = repo.findByOwnerId(ownerId); //changed from owner.getInventory();
			if (originalInventory.getItems() == null) {
				originalInventory.setItems(new HashSet<Item>());
			}
			if (originalInventory.getItems().size() < 28) {
				originalInventory.setOwner(characterRepo.findOne(ownerId));
				originalInventory.setItems(
					convertItemsToSet(itemRepo.findAll(itemIds))
				);
				originalInventory.setWorth(
					calculateNetWorth(
						originalInventory.getItems(), characterRepo.findOne(ownerId).getCharisma())
				);
				originalInventory.setWeight(
					calculateNetWeight(originalInventory.getItems())
				);
				originalInventory.setSize(
						originalInventory.getSize()
						);
				associateItemsWithInventory(originalInventory);
			}
			return repo.save(originalInventory);
		} catch (Exception e) {
			logger.error("Unable to add items to inventory with id: " + ownerId, e);
			throw new Exception("Unable to add to inventory");
		}
	}

	public void associateItemsWithInventory(Inventory inventory) {
		for (Item item : inventory.getItems()) {
			item.setInventory(inventory);
		}
	}

	public int calculateCharisma(Long id) {
		return characterRepo.findOne(id).getCharisma();
	}

	public Set<Item> convertItemsToSet(Iterable<Item> iterableItem) {
		Set<Item> itemSet = new HashSet<Item>();
		for (Item item : iterableItem) {
			itemSet.add(item);
		}
		return itemSet;
	}

	public int getItemQuantity(Inventory inventory) {
		return inventory.getItems().size();
	}

	public int calculateNetWorth(Set<Item> items, int charismaModifier) {
		int worth = 0;
		for (Item item : items) {
			worth += item.getCost();
		}
		return worth * charismaModifier / 4;
	}
	
	//TODO: Use strength stat as a net weight modifier
	public int calculateNetWeight(Set<Item> items) {
		int weight = 0;
		for (Item item : items) {
			weight += item.getWeight();
		}
		return weight;
	}

	//Used to shorten conditionals, returns remaining space (out of maximum of 28) as int
	public int getSpaceRemaining(Inventory inventory) {
		return inventory.getSize() - inventory.getItems().size();
	}

	public Inventory getInventoryById(Long id) {
		return repo.findOne(id);
	}

	//Deletes inventory by id
	public void deleteInventory(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete inventory" + id, e);
			throw new Exception("Unable to delete inventory");
		}
	}

}

	





















