package com.example.greetingapp.controller.uc1; 

import com.example.greetingapp.common.UserDto;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/greeting/uc1")
public class GreetingControllerUC1 {
	
	@GetMapping
	public ResponseEntity<String> getGreeting(){
		return new ResponseEntity<>("Hello from BridgeLabz !",HttpStatus.OK);
	} 
	
	@GetMapping("/param/{name}")
	public ResponseEntity<String> getGreetingPathVariable(@PathVariable String name){
		return new ResponseEntity<>("Hello " + name + " from BridgeLabz!", HttpStatus.OK);
	}
	
	@GetMapping("/query")
	public ResponseEntity<String> getGreeting(@RequestParam(name="name")String name){
		return new ResponseEntity<>("Hello " + name + " from BridgeLabz!", HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> postGreeting(@RequestBody UserDto userDto){
		String fullName="";
		if(userDto.getFirstName()!=null && userDto.getLastName() !=null) {
			fullName=userDto.getFirstName() +" "+userDto.getLastName();
		} 
		else if(userDto.getFirstName()!=null) {
			fullName=userDto.getFirstName();		
		}
		else if(userDto.getLastName() !=null) {
			fullName=userDto.getLastName();
		} 
		else {
			fullName="Guest";
		}  
		return new ResponseEntity<>("Hello " + fullName + " from BridgeLabz!", HttpStatus.CREATED);
	}  
	
	
	@PutMapping
	public ResponseEntity<String> putGreeting(@PathVariable String firstName ,@RequestParam(name="lastName") String lastName){
		return new ResponseEntity<>("Hello " + firstName + " " + lastName + " from BridgeLabz!", HttpStatus.OK);
	} 
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteGreeting(@PathVariable Long id){
		return new ResponseEntity<>("Successfully deleted greeting with ID: " + id, HttpStatus.NO_CONTENT);
	} 
}
	
	
	


