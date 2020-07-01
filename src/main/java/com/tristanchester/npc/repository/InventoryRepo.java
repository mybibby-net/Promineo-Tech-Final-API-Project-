package com.tristanchester.npc.repository;

import org.springframework.data.repository.CrudRepository;

import com.tristanchester.npc.entity.Inventory;
import com.tristanchester.npc.entity.Item;

public interface InventoryRepo extends CrudRepository <Inventory, Long>{

    public Inventory findByOwnerId(Long id);

}
