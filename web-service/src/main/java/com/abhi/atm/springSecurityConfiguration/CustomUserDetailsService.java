package com.abhi.atm.springSecurityConfiguration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhi.atm.springSecurityConfiguration.CustomUserDetails;
import com.abhi.atm.springSecurityConfiguration.User;
import com.abhi.atm.springSecurityConfiguration.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> users = userRepository.findByUserName(userName);
		users.orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found.."));
		CustomUserDetails user = users.map(CustomUserDetails::new).get();
		return user;
	}

}
