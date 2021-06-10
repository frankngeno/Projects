package com.fngeno.department_services.services;

import com.fngeno.department_services.entity.Department;
import com.fngeno.department_services.repository.DeptRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DeptServices {
    @Autowired
    private DeptRepo deptRepo;

    public Department save(Department department) {
        log.info("Inside save Department service ");
        return deptRepo.save(department);
    }

    public Optional<Department> findDepartmentById(Long departmentId) {
        log.info("Inside find Department service ");
        return deptRepo.findById(departmentId);
    }
}
