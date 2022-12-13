package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("priya").password("priya123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("user123").roles("USER");
	}
	//security for all API
	/*@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}*/
	
	//security based on url
	/*@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/noAuth/**").fullyAuthenticated().and().httpBasic();
	}*/
	
	// security based on role
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/noAuth/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
	}
	
	
	@Bean
	public NoOpPasswordEncoder getNoOpPasswordEncoder()
	{
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}
	

}
