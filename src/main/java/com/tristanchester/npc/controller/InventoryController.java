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

import javax.xml.ws.Response;

@RestController
@RequestMapping("characters/{id}/inventory") 
public class InventoryController {
	
	@Autowired
	private InventoryService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createInventory (
			@RequestBody Set<Long> itemIds, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(
					service.createNewInventory(itemIds, id), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{inventoryId}")
	public ResponseEntity<Object> getInventory(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getInventoryById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	//PUT: Adds set of item id's to inventory
	@RequestMapping(value = "/{inventoryId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateInventory(
			@RequestBody Set<Long> itemIds, @PathVariable Long inventoryId) {
			try {
				return new ResponseEntity<Object>(
					service.addItems(itemIds, inventoryId), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
}
































