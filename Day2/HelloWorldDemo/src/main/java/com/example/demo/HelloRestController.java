package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {
	
	@RequestMapping("/")
	public String index() {
		return " Hello from my side";
	}
}
