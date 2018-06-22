package com.abhi.atm.springSecurityConfiguration;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhi.atm.springSecurityConfiguration.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	Optional<User> findByUserName(String userName);
}
