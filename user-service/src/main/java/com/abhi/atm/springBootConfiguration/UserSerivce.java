package com.abhi.atm.springBootConfiguration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSerivce {

	@GetMapping("/getAllUsers")
	public String hello() {
		return "hello from user service";
	}
}
