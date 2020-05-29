package com.tristanchester.npc.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tristanchester.npc.entity.Inventory;
import com.tristanchester.npc.service.InventoryService;

@RestController
@RequestMapping("characters/{id}/inventory") 
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createInventory (
			@RequestBody Set<Long> itemIds, @PathVariable Long ownerId
			) {
		try {
			return new ResponseEntity<Object>(
					service.initializeNewEmptyInventory(ownerId), HttpStatus.CREATED
					);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					e, HttpStatus.BAD_REQUEST
					);
		}
	}
	
	
	public ResponseEntity<Object> updateInventory(
			@RequestBody Inventory inventory, @PathVariable Long ownerId
			) {
		try {
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
































