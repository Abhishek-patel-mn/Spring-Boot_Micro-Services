package com.abhi.atm.springBootConfiguration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.abhi")
@EnableMongoRepositories("com.abhi")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// ModelMapper used for convertin DTO to entity and viceversa.
	@Bean
	public ModelMapper modelMapper() {
		System.out.println("======== Creating Model Map object ==========");
		return new ModelMapper();
	}

	// Password encryptor and decryptor.
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	
	// Sending request trace to zipkin server always..
	@Bean
	Sampler getSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
