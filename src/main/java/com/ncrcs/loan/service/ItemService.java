package com.ncrcs.loan.service;

import com.ncrcs.loan.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ItemService {

	private final List<Item> items = new CopyOnWriteArrayList<>();

	public ItemService() {
		items.add(new Item(1L, "Item One", "First sample item"));
		items.add(new Item(2L, "Item Two", "Second sample item"));
		items.add(new Item(3L, "Item Three", "Third sample item"));

	}

	public List<Item> findAll() {
		return List.copyOf(items);
	}

	public Optional<Item> findById(Long id) {
		return items.stream()
				.filter(item -> item.getId().equals(id))
				.findFirst();
	}
}
