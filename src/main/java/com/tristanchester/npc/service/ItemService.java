package com.tristanchester.npc.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tristanchester.npc.entity.Item;
import com.tristanchester.npc.repository.ItemRepo;

@Service
public class ItemService {
	//TODO: Add additional logic for items, make more elaborate

	private final static Logger logger = LogManager.getLogger(ItemService.class);
	
	@Autowired
	private ItemRepo repo;
	
	public Iterable<Item> getAllItems() {
		return repo.findAll();
	}
	
	public Item createItem(Item item) {
		return repo.save(item);
	}
	
	public Item modifyItem(Item item, Long id) throws Exception {
		try {
			Item original = repo.findOne(id);
			original.setName(
					item.getName());
			original.setDescription(
					item.getDescription());
			original.setCost(
					item.getCost());
			original.setWeight(
					item.getWeight());
			return repo.save(original);
		} catch (Exception e) {
			logger.error("Exception occurred while attempting to modify item: " + id, e);
			throw new Exception("Unable to modify item");
		}
	}
	
	public void removeItem(Long id) throws Exception{
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to remove item: " + id, e);
			throw new Exception("Unable to remove item");
		}
	}
	
}




































