package com.grl.webfluxAPIDemo.controller;

import com.grl.webfluxAPIDemo.EmployeeRepository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
private Flux<Employee> getAllEmployees(){
        return employeeRepository.findAllEmployees();
}

}
