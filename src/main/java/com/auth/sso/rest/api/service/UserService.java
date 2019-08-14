package com.auth.sso.rest.api.service;

import org.springframework.stereotype.Service;

import com.auth.sso.rest.api.models.LoginRequest;
import com.auth.sso.rest.api.models.User;

@Service
public interface UserService {

	boolean login(LoginRequest loginRequest);

	User register(User user);

}
