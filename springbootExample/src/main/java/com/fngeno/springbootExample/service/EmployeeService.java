package com.fngeno.springbootExample.service;

import com.fngeno.springbootExample.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    void delete(Long id);
}
