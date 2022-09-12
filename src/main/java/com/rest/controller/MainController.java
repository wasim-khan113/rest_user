package com.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.User;
import com.rest.repository.UserRepository;

@RestController
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> list = userRepository.findAll();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		this.userRepository.save(user);
		return user;
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			this.userRepository.save(user);

			return ResponseEntity.of(Optional.of(user));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user = this.userRepository.findById(id);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(user));
		}

	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		try {
			this.userRepository.deleteById(id);
			return ResponseEntity.of(Optional.of("deleted successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
