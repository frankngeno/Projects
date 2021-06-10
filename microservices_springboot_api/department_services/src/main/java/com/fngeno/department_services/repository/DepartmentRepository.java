package com.fngeno.department_services.repository;

import com.fngeno.department_services.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo extends JpaRepository <Department, Long>{

}
