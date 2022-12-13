package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableWebSecurity
public class CustomSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
protected void configure(AuthenticationManagerBuilder auth) throws Exception
{
	auth.inMemoryAuthentication()
	.withUser("user")
	.password("user123")
	.roles("USER")
	.and()
	.withUser("admin")
	.password("admin123")
	.roles("ADMIN");
}
@Bean
public PasswordEncoder getPasswordEncoder()
{
	return NoOpPasswordEncoder.getInstance();
}
}
