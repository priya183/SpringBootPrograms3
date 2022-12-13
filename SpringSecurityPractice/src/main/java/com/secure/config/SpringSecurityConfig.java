package com.secure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("priya").password("priya123").roles("ADMIN");
		
	}
	//in which method you want to add security
	//here security added in all API
	/*protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}*/
	
	//
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/noAuth/**").fullyAuthenticated().and().httpBasic();
	}
	
	// here password is required in encrypted format
	@Bean
	public NoOpPasswordEncoder getNoOpPasswordEncoder()
	{
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}

}
