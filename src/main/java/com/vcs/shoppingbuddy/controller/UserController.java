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

import com.vcs.shoppingbuddy.model.User;
import com.vcs.shoppingbuddy.repo.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class UserController {

	@Autowired
	private UserRepository userRepository;	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody User userParam) {
		User user = userRepository.save(userParam);
		try {
			return ResponseEntity.created(new URI("/user/" + user.getName())).build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
	
	@RequestMapping(value = "/user/email/{email}", method = RequestMethod.GET)
	List<User> getUserByEmail(@PathVariable("email") String  email) {
		return userRepository.findUserByemailId(email);
	}	
}
