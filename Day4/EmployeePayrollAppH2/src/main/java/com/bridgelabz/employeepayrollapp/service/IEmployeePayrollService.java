package com.bridgelabz.employeepayrollapp.service;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;


public interface IEmployeePayrollService {
	List<EmployeePayrollData> getAllEmployeePayrollData();
   
    EmployeePayrollData getEmployeePayrollDataById(long empId);
    
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeeDTO);
    
    EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDTO employeeDTO);
   
    void deleteEmployeePayrollData(long empId);
}