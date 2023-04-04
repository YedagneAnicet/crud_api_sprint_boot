package com.openclassroom.api.service;

import com.openclassroom.api.model.Employee;

import java.util.List;

public interface EmployeeService {
        Employee save(Employee employee);
        Employee update(Long id, Employee employee);
        Employee findById(Long id);
        List<Employee> findAll();
        void delete(Long id);

}
