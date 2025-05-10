package com.example.springconcepts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.springconcepts.component.DepartmentBean;
import com.example.springconcepts.component.EmployeeBean; // Import EmployeeBean

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringconceptsApplication {

    public static final Logger logger = LoggerFactory.getLogger(SpringconceptsApplication.class); // Corrected casting

    public static void main(String[] args) {
        logger.debug("Welcome");
        // Pass the main application class to run
        ApplicationContext context = SpringApplication.run(SpringconceptsApplication.class, args);

        logger.debug("Checking context for DepartmentBean: {}", context.getBean(DepartmentBean.class));

        logger.debug("@Autowire property demonstration:");

        // Get an instance of EmployeeBean from the Spring context
        EmployeeBean employeeBean = context.getBean(EmployeeBean.class);

        // Set some employee properties
        employeeBean.setEid(101);
        employeeBean.setEname("Alice Smith");

        // Call the method that uses the injected DepartmentBean
        employeeBean.showEployeeDetails();

        // Optionally, retrieve DepartmentBean again to confirm it's the same instance
        DepartmentBean retrievedDeptBean = context.getBean(DepartmentBean.class);
        logger.debug("Retrieved DepartmentBean directly: {}", retrievedDeptBean);
        logger.debug("DepartmentBean from EmployeeBean: {}", employeeBean.getDeptBean());
        logger.debug("Are they the same instance? {}", (retrievedDeptBean == employeeBean.getDeptBean()));

    }
}