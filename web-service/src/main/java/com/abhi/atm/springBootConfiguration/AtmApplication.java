package com.abhi.atm.springBootConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.abhi.atm.springSecurityConfiguration.SessionListener;

/**
 * @author Abhishek Patel M N Jan 18, 2018
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan("com.abhi")
@EnableMongoRepositories("com.abhi")
@EnableFeignClients
public class AtmApplication extends SpringBootServletInitializer {

	// Spring boot configuration to use wildfly.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("======== inside Spring boot configure method ==========");
		return application.sources(AtmApplication.class);
	}

	// Main method
	public static void main(String[] args) {
		System.out.println("======== inside Mian method ==========");
		SpringApplication.run(AtmApplication.class, args);
	}

	// ModelMapper used for convertin DTO to entity and viceversa.
	@Bean
	public ModelMapper modelMapper() {
		System.out.println("======== Creating Model Map object ==========");
		return new ModelMapper();
	}

	// Session listner for create and delete
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.addListener(new SessionListener());
	}
	
	// Password encryptor and decryptor.
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
}
