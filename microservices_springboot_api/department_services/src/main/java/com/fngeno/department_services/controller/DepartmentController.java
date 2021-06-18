package com.fngeno.department_services.controller;


import com.fngeno.department_services.entity.Department;
import com.fngeno.department_services.repository.DepartmentRepository;
import com.fngeno.department_services.services.DepartmentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;


    @PostMapping("/")
    public Department saveDepartment (@RequestBody Department department){
       log.info("Inside saveDepartment method of departmentController ");
        return departmentRepository.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById (@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById method of Controller ");
        return departmentRepository.findDepartmentById(departmentId);
    }


}