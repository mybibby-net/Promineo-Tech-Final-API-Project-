package com.tristanchester.npc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tristanchester.npc.entity.Character;
import com.tristanchester.npc.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createCharacter(@RequestBody Character character) {
		return new ResponseEntity<Object>(
				service.createCharacter(character), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCharacter(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(
					service.getCharacterById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	//TODO: Implement retreival of ALL characters (convert characters into set and return?)
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Object> getAllCharacters() {
//		return new ResponseEntity<Object>(
//				service.getCharacters(), HttpStatus.OK);
//	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> modifyCharacter(@RequestBody Character character, @PathVariable Long id) throws Exception {
		try {
			return new ResponseEntity<Object>(
					service.modifyCharacterInfo(character), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> removeCharacter(@PathVariable Long id) {
		try {
			service.removeCharacter(id);
			return new ResponseEntity<Object>(
					"Successfully removed character with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}


















