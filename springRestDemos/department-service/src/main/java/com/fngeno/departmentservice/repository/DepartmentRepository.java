package com.fngeno.department.repository;

import com.fngeno.department.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
// create a list.
    @Query("FROM Department d WHERE d.departmentCode = ?1")
    List<Department> findDepartmentById(Long departmentId);

}
