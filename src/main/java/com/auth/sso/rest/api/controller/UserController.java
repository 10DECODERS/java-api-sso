package com.auth.sso.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.sso.rest.api.models.LoginRequest;
import com.auth.sso.rest.api.models.User;
import com.auth.sso.rest.api.service.UserService;
import com.auth.sso.rest.api.service.impl.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	SequenceGeneratorService seqGeneratorService;

	@PostMapping("/login")
	public boolean login(@RequestBody LoginRequest loginRequest) {
		loginRequest.setEmail(loginRequest.getEmail().toLowerCase());
		loginRequest.setPassword(loginRequest.getPassword());
		boolean loggedIn = userService.login(loginRequest);
		// we are returning boolean value to Auth0 Service which is recommended
		// Whereas token generation is happening in auth0, so we don't need to worry
		// about
		return loggedIn;
	}

	@PostMapping("/register")
	public User user(@RequestBody User user) {
		user.setEmail(user.getEmail().toLowerCase());
		user.setPassword(user.getPassword());
		user.setId(seqGeneratorService.generateSequence(User.SEQUENCE_NAME));
		user = userService.register(user);
		return user;
	}
}
