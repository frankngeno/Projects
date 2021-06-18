package com.fngeno.departmentservice.repository;

import com.fngeno.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
// create a list.
    //@Query("FROM Department d WHERE d.departmentCode = ?1")
   // List<Department> findDepartmentById(Long departmentId);

    //Optional<Department> findByEmail(String email); //same with -> Department findByEmail(String email);
//advantage of optional, it is like a boolean or you can check if present ans also consume something in it.

}
