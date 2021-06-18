package com.fngeno.departmentservice.controller;


import com.fngeno.departmentservice.entity.Department;
import com.fngeno.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // remove rest controller when you working with frontend
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

//    @PostMapping("/saved")
//    @ResponseStatus(HttpStatus.OK)
//    public Department saveDepartment(@RequestBody Department department) {
//        log.info("Inside saveDepartment method of DepartmentController");
//        return this.departmentService.saveDepartment(department);
//    }
     @PostMapping("/save")
    public Department saveUser(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById method of DepartmentController {}","verify number 2");
        departmentService.findDepartmentById(departmentId).ifPresent(a -> {a.getDepartmentAddress().toUpperCase();});
        return this.departmentService.findDepartmentById(departmentId).get();
    }
}
