package com.secure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ApplicationController {
	
	@GetMapping("/getMsg")
	public String getMsg()
	{
		return "Spring Security Example";
	}

}
