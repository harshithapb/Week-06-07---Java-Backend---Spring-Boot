package com.example.demoIntelliJ;


import org.springframework.web.bind.annotation.*;
import com.example.demoIntelliJ.*;

@RestController
@RequestMapping(value="/hello")
public class HelloRestController {

    @RequestMapping(value={" ","/","/home"})
    public String sayHello(){
        return "Hello from BridgeLabz!!!";
    }
    @RequestMapping(value = {"/query"},method=RequestMethod.GET)
    public String sayHello(@RequestParam(value="name") String name){
        return "Hello "+ name+ " from BridgeLabz!"; // Modified
    }
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name){
        return "Hello "+ name+ " from BridgeLabz!"; // Modified
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user){
        return "Hello " +user.getFirstName() +" "+user.getLastName() + " from BridgeLabz"; // Modified
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName ,@RequestParam(value="lastName") String lastName){ // Changed value to "lastName" to match curl
        return "Hello "+ firstName+ " "+ lastName +" from BridgeLabz!"; // Modified
    }



}





