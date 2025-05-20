package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 

@Entity 
@Table(name = "employee_payroll") 
public class EmployeePayrollData {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID in MySQL
    private long employeeId; 

    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

  
    public EmployeePayrollData(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    
    public EmployeePayrollData(long employeeId, String name, long salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}