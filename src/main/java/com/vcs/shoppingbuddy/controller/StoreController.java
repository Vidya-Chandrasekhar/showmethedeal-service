package com.vcs.shoppingbuddy.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcs.shoppingbuddy.model.Store;
import com.vcs.shoppingbuddy.repo.StoreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;	
	
	@RequestMapping(value = "/store", method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Store storeParam) {
		Store store = storeRepository.save(storeParam);
		try {
			return ResponseEntity.created(new URI("/store/" + store.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}
