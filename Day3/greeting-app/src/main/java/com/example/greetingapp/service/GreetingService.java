package com.example.greetingapp.service;

import com.example.greetingapp.modal.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import com.example.greetingapp.common.UserDto;
import org.springframework.stereotype.Service; 
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService { 
	private static final String TEMPLATE = "Hello %s";
    private final AtomicLong counter = new AtomicLong(); // For simple unique ID generation if not using DB

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    
    public String getSimpleGreeting() {
        return "Hello World";
    }

    public String getGreetingWithUser(UserDto userDto) {
        if (userDto != null) {
            String firstName = userDto.getFirstName();
            String lastName = userDto.getLastName();

            if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
                return "Hello " + firstName + " " + lastName;
            } else if (firstName != null && !firstName.isEmpty()) {
                return "Hello " + firstName;
            } else if (lastName != null && !lastName.isEmpty()) {
                return "Hello " + lastName;
            }
        }
        return getSimpleGreeting(); // Fallback to "Hello World"
    } 
 // Use Case 4: Save Greeting
    public Greeting saveGreeting(UserDto userDto) {
        String messageContent = getGreetingWithUser(userDto);
        Greeting newGreeting = new Greeting(messageContent);
        return greetingRepository.save(newGreeting);
    }

    // Use Case 5: Find Greeting by Id
    public Optional<Greeting> getGreetingById(long id) {
        return greetingRepository.findById(id);
    }

    // Use Case 6: List All Greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Use Case 7: Edit Greeting
    public Greeting updateGreeting(long id, UserDto userDto) {
        return greetingRepository.findById(id)
                .map(greeting -> {
                    String updatedMessage = getGreetingWithUser(userDto);
                    greeting.setMessage(updatedMessage);
                    return greetingRepository.save(greeting);
                })
                .orElseThrow(() -> new RuntimeException("Greeting with ID " + id + " not found to update."));
    }

    // Use Case 8: Delete Greeting
    public void deleteGreeting(long id) {
        if (!greetingRepository.existsById(id)) {
            throw new RuntimeException("Greeting with ID " + id + " not found to delete.");
        }
        greetingRepository.deleteById(id);
    }
}