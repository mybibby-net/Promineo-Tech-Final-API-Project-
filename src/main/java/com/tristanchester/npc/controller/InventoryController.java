package com.tristanchester.npc.controller;

import java.util.Set;

import com.tristanchester.npc.entity.Item;
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

	//Initializes inventory with specified set of items if there are any
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

	//Retrieves inventory by owner id specified as path variable
	@RequestMapping(method = RequestMethod.GET, value="/{inventoryId}")
	public ResponseEntity<Object> getInventory(@PathVariable Long inventoryId) {
		try {
			return new ResponseEntity<Object>(service.getInventoryById(inventoryId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{inventoryId}/items", method = RequestMethod.GET)
	public ResponseEntity<Set<Item>> getItems(@PathVariable Long inventoryId) {
		return new ResponseEntity<Set<Item>>(
			service.getInventoryById(inventoryId).getItems(), HttpStatus.OK
		);
	}

	//Adds set of item id's to inventory
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

	//Removes all items within an inventory
	@RequestMapping(value = "/{inventoryId}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteInventory(@PathVariable Long inventoryId) {
		try {
			service.deleteInventory(inventoryId);
			return new ResponseEntity<Object>("Successfully deleted inventory with id" + inventoryId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete inventory with id:" + inventoryId, HttpStatus.BAD_REQUEST);
		}
	}

}
































