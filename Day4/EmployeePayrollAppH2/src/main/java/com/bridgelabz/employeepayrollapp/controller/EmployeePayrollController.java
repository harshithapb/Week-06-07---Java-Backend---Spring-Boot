package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Employee Payroll Spring App!";
    }

    @GetMapping({"/get", "/"})
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployeePayrollData() {
        List<EmployeePayrollData> employeeList = employeePayrollService.getAllEmployeePayrollData();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeePayrollData(@PathVariable("id") long id) { // Changed to long
        EmployeePayrollData employeeData = employeePayrollService.getEmployeePayrollDataById(id);
        if (employeeData != null) {
            return new ResponseEntity<>(employeeData, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employeeData = employeePayrollService.createEmployeePayrollData(employeeDTO);
        return new ResponseEntity<>(employeeData, HttpStatus.CREATED); // 201
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployeePayrollData(@PathVariable("id") long id, 
                                                                        @RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employeeData = employeePayrollService.updateEmployeePayrollData(id, employeeDTO);
        if (employeeData != null) {
            return new ResponseEntity<>(employeeData, HttpStatus.OK); // 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployeePayrollData(@PathVariable("id") long id) { 
        employeePayrollService.deleteEmployeePayrollData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
    }
}