package com.example.testapp.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail (String email);
    Optional<Employee> findById(Long id);
    void deleteById(Long id);
}
