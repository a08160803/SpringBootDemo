package com.ctbc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {

	@RequestMapping("/say")
	public String hello() {
		return "Hello Spring Boot";
	}

}
