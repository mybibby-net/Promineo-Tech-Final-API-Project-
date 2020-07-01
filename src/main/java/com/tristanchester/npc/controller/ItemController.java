package com.tristanchester.npc.controller;

import com.tristanchester.npc.service.ItemService;
import com.tristanchester.npc.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllItems() {
		return new ResponseEntity<Object>(
				service.getAllItems(), HttpStatus.OK
				);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createItem(@RequestBody Item item) {
		return new ResponseEntity<Object>(
				service.createItem(item), HttpStatus.CREATED
				);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> modifyItem(@RequestBody Item item, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(
					service.modifyItem(item, id), HttpStatus.OK
					);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					"Unable to modify the item", HttpStatus.BAD_REQUEST
					);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteItem(@PathVariable Long id) {
		try {
			service.removeItem(id);
			return new ResponseEntity<Object>(
					"Successfully removed item with id: " + id, HttpStatus.OK
					);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					"Unable to remove item", HttpStatus.BAD_REQUEST
					);
		}
	}
	
}



























