package com.example.greetingapp.controller.uc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 

import org.springframework.web.bind.annotation.*;

import com.example.greetingapp.service.GreetingService;

@RestController 
@RequestMapping("/api/v1/greetings/uc2")
public class GreetingControllerUC2 {
	private final GreetingService greetingService; 
	
	@Autowired 
	public GreetingControllerUC2(GreetingService greetingService) {
		this.greetingService=greetingService;
	} 
	
	@GetMapping
	public ResponseEntity<String> getGreetingFromService(){
		String msg=greetingService.getSimpleGreeting();
		return new ResponseEntity<>(msg + " !",HttpStatus.OK);
	}
}
