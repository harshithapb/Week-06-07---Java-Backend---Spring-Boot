package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private IEmployeePayrollRepository employeeRepository; // Renamed for clarity (optional)

    // Remove: private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    // Remove: private int idCounter = 0;

    @Override
    public List<EmployeePayrollData> getAllEmployeePayrollData() {
        // Fetch all data directly from the database using the repository
        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(long empId) {
        // Fetch data by ID from the database using the repository
        // Optional<EmployeePayrollData> employee = employeeRepository.findById(empId);
        // return employee.orElse(null); // Or use .orElseThrow(new EmployeeNotFoundException("Employee with ID " + empId + " not found"));
        return employeeRepository.findById(empId)
                                 .orElse(null); // Recommended to handle not found case explicitly
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employeeData = new EmployeePayrollData();
        employeeData.setName(employeeDTO.getName());
        employeeData.setSalary(employeeDTO.getSalary());
     
        return employeeRepository.save(employeeData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDTO employeeDTO) {
  
        Optional<EmployeePayrollData> optionalEmployee = employeeRepository.findById(empId);

        if (optionalEmployee.isPresent()) {
            EmployeePayrollData existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setSalary(employeeDTO.getSalary());
           
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployeePayrollData(long empId) {
        // Delete the employee from the database by ID
        employeeRepository.deleteById(empId);
        System.out.println("Employee with ID " + empId + " deleted from database.");
    }
}