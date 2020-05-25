package com.tristanchester.npc.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tristanchester.npc.service.InventoryService;

@RestController
//@RequestMapping("") //Resolve mapping issue, see block comment
public class InventoryController {
	
}
/*
 * TODO: Review to see if necessary to create inventory controller
 * 	ALL characters will have an inventory, therefore can be updated
 * 	via NPC or PlayerCharacter controllers instead
 * 	
 * Solution 1: Create two seperate REST controllers for Player/NPC inventories
 * 	and map each accordingly
 * 
 * Solution 2: Merge PlayeCharacter and NPC's into one character class,
 * 	then create a "characterType" or equivalent var to differentiate the two
 * 	
 * Reasoning: using @RequestMapping("../../..") would result in some REST weirdness
 * 	with current program class configurations regarding differences between
 * 	PlayerCharacters and NPC's, which while nearly identical, are different classes
 * 
 */