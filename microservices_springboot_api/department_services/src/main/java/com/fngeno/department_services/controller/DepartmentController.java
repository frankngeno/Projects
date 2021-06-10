package com.fngeno.department_services.controller;


import com.fngeno.department_services.entity.Department;
import com.fngeno.department_services.services.DeptServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DeptController {
    @Autowired
    private DeptServices deptServices;

    @PostMapping("/")
    public Department saveDepartment (@RequestBody Department department){
       log.info("Inside saveDepartment method of departmentController ");
        return deptServices.save(department);
    }

    @GetMapping("{id}")
    public Optional<Department> findDepartmentById(@RequestParam Long departmentId){
        log.info("Inside findDepartmentById method of Controller ");
        return deptServices.findDepartmentById(departmentId);
    }


}