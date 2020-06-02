package com.tristanchester.npc.service;


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
import com.tristanchester.npc.service.InventoryService; //For use in initializing empty inventory

@Service
public class CharacterService {
	
	private static final Logger logger = LogManager.getLogger(CharacterService.class);
	
	@Autowired
	private CharacterRepo repo;

	private InventoryRepo inventoryRepo;
//	private InventoryService inventoryService;
	
	public Character getCharacterById(Long id) {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve character: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Character> getCharacters() { return repo.findAll(); }
	
	public Character createCharacter(Character character) {
//		initInventory(character.getId());
		return repo.save(character);
	}

	//TODO: Add Character stats to modify NOTE: setInventory() has not been implemented in this method, consider removing inventory logic
	//Takes character arg, when called will check amount of items within character's inventory to ensure limits aren't broken
	public Character modifyCharacterInfo(Character character) throws Exception {
			if (character.getInventory().getItems().size() > character.getInventory().getSize()) {
				try {
					Character original = repo.findOne(character.getId());
					original.setName(character.getName());
					original.setAge(character.getAge());
					original.setType(character.getType());
					original.setLocation(character.getLocation());
					repo.save(original);
					return original;
				} catch (Exception e) {
					logger.error("Exception occurred while trying to modify character: " + character.getId() + e);
					throw new Exception("Unable to modify character information");
				}
			} else {
				try {
					Character original = repo.findOne(character.getId());
					original.setName(character.getName());
					original.setAge(character.getAge());
					original.setType(character.getType());
					original.setLocation(character.getLocation());
					repo.save(original);
					return original;
				} catch (Exception e) {
			logger.error("Exception occurred while trying to modify character: " + character.getId() + e);
			throw new Exception("Unable to modify character information");
				}
			}
	}

//	public void initInventory(Long id) {
//		Inventory inventory = new Inventory();
//		inventory.setItems(null);
//		inventory.setOwner(repo.findOne(id));
//		inventory.setSize(28); //28 as default size, think "slots"
//		inventory.setWorth(0);
//		inventory.setWeight(0);
//	}
	
	public void removeCharacter(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while attempting to remove character" + id + e);
			throw new Exception("Unable to remove character");
		}
	}
	
}


























