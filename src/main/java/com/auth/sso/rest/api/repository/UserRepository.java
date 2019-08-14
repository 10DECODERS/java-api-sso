package com.auth.sso.rest.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.auth.sso.rest.api.models.LoginRequest;
import com.auth.sso.rest.api.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>, CrudRepository<User, Long> {
	
	LoginRequest findByEmailAndPassword(String email, String password);

}
