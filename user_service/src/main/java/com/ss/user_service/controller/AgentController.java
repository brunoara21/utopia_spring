package com.ss.user_service.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.user_service.entity.Booking;
import com.ss.user_service.entity.User;
import com.ss.user_service.service.UserService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users/agent")
public class AgentController {

	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(AgentController.class);

	
	@GetMapping(value="")
	@ResponseBody
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public Optional<User> getUserById(@PathVariable Integer userId) {
		Optional<User> user = userService.getUserById(userId);
		
		logger.error("HELLO");
		return user;
	}
	
	
	@PostMapping("/{userId}/booking")
	public Mono<Booking> createBooking(@PathVariable Integer userId, @RequestBody Booking booking) {
		return userService.createBooking(userId, booking);
	}
}
