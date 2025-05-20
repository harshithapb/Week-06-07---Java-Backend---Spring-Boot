package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayrollH2AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollH2AppApplication.class, args);
		System.out.println("Employee Payroll App Started Successfully on Port 8080!");
	}

}
