package com.tristanchester.npc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tristanchester.npc.entity.Character;
import com.tristanchester.npc.repository.CharacterRepo;

@Service
public class CharacterService {
	
	private static final Logger logger = LogManager.getLogger(CharacterService.class);
	
	@Autowired
	private CharacterRepo repo;
	
	public Character getCharacterById(Long id) {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to retrieve character: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Character> getCharacters() {
		return repo.findAll();
	}
	
	public Character createCharacter(Character character) {
		return repo.save(character);
	}
	
	public Character modifyCharacterInfo(Character character, Long id) throws Exception {
		try {
			Character original = repo.findOne(id);
			original.setName(character.getName());
			original.setAge(character.getAge());
			original.setType(character.getType());
			original.setLocation(character.getLocation());
			repo.save(original);
			return original;
		} catch (Exception e) {
			logger.error("Exception occured while trying to modify character: " + id + e);
			throw new Exception("Unable to modify character information");
		}
		
	}
	
	public void removeCharacter(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occured while attepmting to remove character" + id + e);
			throw new Exception("Unable to remove character");
		}
	}
	
}


























