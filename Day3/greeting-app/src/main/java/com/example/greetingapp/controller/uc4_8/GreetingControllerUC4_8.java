package com.example.greetingapp.controller.uc4_8;

import com.example.greetingapp.common.UserDto;
import com.example.greetingapp.modal.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 

import java.util.List;

@RestController
@RequestMapping("/api/v1/greetings/uc4-8") // Unique base path for this use case
public class GreetingControllerUC4_8 {

    private final GreetingService greetingService;

    @Autowired
    public GreetingControllerUC4_8(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

   
    @PostMapping("/save")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody(required = false) UserDto userDto) {
        Greeting savedGreeting = greetingService.saveGreeting(userDto);
        return new ResponseEntity<>(savedGreeting, HttpStatus.CREATED);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable long id) {
        return greetingService.getGreetingById(id)
                .map(greeting -> new ResponseEntity<>(greeting, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

  
    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        List<Greeting> greetings = greetingService.getAllGreetings();
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

 
    @PutMapping("/update/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable long id, @RequestBody UserDto userDto) {
        try {
            Greeting updatedGreeting = greetingService.updateGreeting(id, userDto);
            return new ResponseEntity<>(updatedGreeting, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable long id) {
        try {
            greetingService.deleteGreeting(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}