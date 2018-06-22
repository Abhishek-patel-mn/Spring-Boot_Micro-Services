package com.abhi.atm.springBootConfiguration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service")
@RibbonClient(name = "user-service")
@Component
public interface UserProxy {
	
	@GetMapping("/getAllUsers")
	public String hello();
	
	@GetMapping("/public/users")
	public ResponseEntity<String> getAllUsers();

}
