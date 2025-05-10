package com.example.springconcepts.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeBean {
    private int eid;
    private String ename; 

    @Autowired 
    private DepartmentBean deptBean;

    public static final Logger logger = LoggerFactory.getLogger(EmployeeBean.class);
    public EmployeeBean() {} 


    @Autowired
    public EmployeeBean (DepartmentBean deptBean) {
        logger.trace("*** Autowiring by using @Autowire annotation on constructor ***"); 
        this.deptBean=deptBean;
    } 

    public int getEid(){
        return eid;
    }  
    public void setEid(int eid){
        this.eid=eid;;
    } 


    public void setEname(String ename){
        this. ename= ename;
    }

    public String getEname(){
       return ename;
    }  
    public DepartmentBean  getDeptBean(){
        return deptBean;
    } 


    @Autowired  
    public void setDeptBean (DepartmentBean deptBean) {
        logger.trace("*** Autowiring by using @Autowire annotation on Setter ***"); 
        this.deptBean=deptBean;
    }
    public void showEployeeDetails(){
        logger.debug("Employee Id: {}",eid);
        logger.debug("Employee Name: {}", ename);
        deptBean.setDeptName("Information Technology");
        logger.debug("Department: {}", deptBean.getDeptName());
    }






}


