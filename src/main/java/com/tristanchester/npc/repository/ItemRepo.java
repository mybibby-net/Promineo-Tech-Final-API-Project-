package com.tristanchester.npc.repository;

import com.tristanchester.npc.entity.Item;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, Long>{

}
