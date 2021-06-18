package com.fngeno.springbootExample.repository;

import com.fngeno.springbootExample.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(@Param("lastName") String lastName);
    List<Employee> findByFirstName(@Param("firstName") String firstName);
    Optional<Employee> findById(@Param("id") Long id);

}
