package com.vcs.shoppingbuddy.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcs.shoppingbuddy.model.Item;
import com.vcs.shoppingbuddy.model.ItemCategory;
import com.vcs.shoppingbuddy.repo.ItemCategoryRepository;
import com.vcs.shoppingbuddy.repo.ItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemCategoryRepository itemCategoryRepository;

	
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Item item) {
		Item createdItem = itemRepository.save(item);
		try {
			return ResponseEntity.created(new URI("/items/" + createdItem.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	Iterable<ItemCategory> getCategories() {
		return itemCategoryRepository.findAll();
	}	
	
	@RequestMapping(value = "/items/{categoryID}", method = RequestMethod.GET)
	List<Item> getItems(@PathVariable("categoryID") long categoryID) {
		return itemRepository.findItemByCategory(categoryID);
	}

	public ItemRepository getItemRepository() {
		return itemRepository;
	}

	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
}