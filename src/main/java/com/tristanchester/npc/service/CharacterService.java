package com.tristanchester.npc.service;


import com.tristanchester.npc.entity.Inventory;
import com.tristanchester.npc.entity.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tristanchester.npc.entity.Character;
import com.tristanchester.npc.repository.CharacterRepo;
import com.tristanchester.npc.repository.InventoryRepo;
import com.tristanchester.npc.service.InventoryService;

import java.util.HashSet;

@Service
public class CharacterService {

	private InventoryService invService;
	private InventoryRepo invRepo;

	private static final Logger logger = LogManager.getLogger(CharacterService.class);
	
	@Autowired
	private CharacterRepo repo;
	
	public Character getCharacterById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve character: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Character> getCharacters() { return repo.findAll(); }
	
	public Character createCharacter(Character character) {
		Inventory inventory = new Inventory();
		inventory.setItems(new HashSet<Item>());
		inventory.setOwner(character);
		character.setInventory(inventory);
		return repo.save(character);
	}

	public Character modifyCharacterInfo(Character character) throws Exception {
		try {
			Character original = repo.findOne(character.getId());
			original.setName(character.getName());
			original.setAge(character.getAge());
			original.setType(character.getType());
			original.setHealth(character.getHealth());
			original.setStamina(character.getStamina());
			original.setStrength(character.getStrength());
			original.setIntellect(character.getIntellect());
			original.setCharisma(character.getCharisma());
			repo.save(original);
			return original;
			} catch (Exception e) {
				logger.error("Exception occurred while trying to modify character: " + character.getId() + e);
				throw new Exception("Unable to modify character information");
			}

	}
	
	public void removeCharacter(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while attempting to remove character" + id + e);
			throw new Exception("Unable to remove character");
		}
	}
	
}


























