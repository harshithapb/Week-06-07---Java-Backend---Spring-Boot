package com.example.greetingapp.controller.uc3;

import com.example.greetingapp.common.UserDto;
import com.example.greetingapp.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/greetings/uc3") // Unique base path for this use case
public class GreetingControllerUC3 {

    private final GreetingService greetingService;

    @Autowired
    public GreetingControllerUC3(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<String> getSimpleGreeting() {
        return new ResponseEntity<>(greetingService.getSimpleGreeting() + "!", HttpStatus.OK);
    }

    @PostMapping("/flexible")
    public ResponseEntity<String> getFlexibleGreeting(@RequestBody(required = false) UserDto userDto) {
        String message = greetingService.getGreetingWithUser(userDto);
        return new ResponseEntity<>(message + "!", HttpStatus.OK);
    }
}