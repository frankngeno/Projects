package com.fngeno.department.service;


import com.fngeno.department.entity.Department;
import com.fngeno.department.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    private static Logger log = LoggerFactory.getLogger(Department.class);

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartmentById method of DepartmentService");
        return departmentRepository.save(department);
    }
    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return departmentRepository.findDepartmentById(departmentId);
    }
}
