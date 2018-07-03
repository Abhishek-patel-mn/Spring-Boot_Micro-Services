package com.abhi.atm.springBootConfiguration;

import javax.validation.Valid;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abhi.atm.springSecurityConfiguration.User;

@FeignClient(name = "atm-api-gate-way")
@RibbonClient(name = "user-service")
@Component
public interface UserProxy {
	
	@PostMapping(value = "user-service/public/users")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user);
	
	@GetMapping("user-service/public/users")
	public ResponseEntity<String> getAllUsers();
	
	@PutMapping(value ="user-service/secured/users")
	public ResponseEntity<String> updateUser(@RequestBody User user);

}
