package com.fngeno.department.controller;

import com.fngeno.department.entity.Department;
import com.fngeno.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById method of DepartmentController");
        return this.departmentService.findDepartmentById(departmentId);
    }
}
