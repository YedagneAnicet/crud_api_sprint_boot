package com.openclassroom.api.service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassroom.api.model.Employee;
import com.openclassroom.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        if(employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        if(employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        Employee existingEmployee = findById(id);
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setMail(employee.getMail());
        existingEmployee.setPassword(employee.getPassword());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()) {
            throw new EntityNotFoundException("Employee with id " + id + " not found");
        }
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Employee existingEmployee = findById(id);
        employeeRepository.delete(existingEmployee);
    }
}

