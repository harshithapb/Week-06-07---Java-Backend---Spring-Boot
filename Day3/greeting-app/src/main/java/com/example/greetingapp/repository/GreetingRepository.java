package com.example.greetingapp.repository;

import com.example.greetingapp.modal.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    // JpaRepository provides basic CRUD methods like save, findById, findAll, deleteById etc.
}