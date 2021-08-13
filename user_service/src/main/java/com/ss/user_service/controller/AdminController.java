package com.ss.user_service.controller;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.user_service.entity.User;
import com.ss.user_service.service.UserService;

@RestController
@RequestMapping("/users/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@GetMapping(value="")
	@ResponseBody
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public Optional<User> getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/admin")
	public User createAdmin(@RequestBody User user) {
		return userService.createAdmin(user, "admin");
	}
	
	
}
