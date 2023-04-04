package com.openclassroom.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.api.model.Employee;
import com.openclassroom.api.service.EmployeeServiceImp;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeService;


    @PostMapping("/createEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/getEmployees")
    public Iterable<Employee> getEmployees() {
        return employeeService.findAll();
    }


}