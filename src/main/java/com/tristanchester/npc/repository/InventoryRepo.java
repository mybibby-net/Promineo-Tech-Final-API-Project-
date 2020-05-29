package com.tristanchester.npc.repository;

import org.springframework.data.repository.CrudRepository;

import com.tristanchester.npc.entity.Inventory;

public interface InventoryRepo extends CrudRepository <Inventory, Long>{

}
