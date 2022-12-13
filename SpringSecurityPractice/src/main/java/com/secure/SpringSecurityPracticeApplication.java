package com.secure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@EnableWebSecurity
@SpringBootApplication
public class SpringSecurityPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPracticeApplication.class, args);
		System.out.println("SpringSecurityPracticeApplication started...!!");
	}

}
