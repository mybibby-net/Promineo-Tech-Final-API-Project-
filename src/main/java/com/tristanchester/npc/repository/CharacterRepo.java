package com.tristanchester.npc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tristanchester.npc.entity.Character;

@Repository
public interface CharacterRepo extends CrudRepository<Character, Long>{
	
}
