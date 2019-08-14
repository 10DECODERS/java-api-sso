package com.auth.sso.rest.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.sso.rest.api.models.LoginRequest;
import com.auth.sso.rest.api.models.User;
import com.auth.sso.rest.api.repository.UserRepository;
import com.auth.sso.rest.api.service.UserService;

@Service
public class IUserService implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public boolean login(LoginRequest loginRequest) {
		LoginRequest loginRequestResponse = userRepo.findByEmailAndPassword(loginRequest.getEmail(),
				loginRequest.getPassword());
		if (loginRequestResponse.getEmail() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User register(User user) {
		return userRepo.save(user);
	}
}
