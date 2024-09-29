package com.example.testapp.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceEmployee {

    EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employee.getEmail());
        if (employeeOptional.isPresent()) throw new IllegalStateException("this email already exist");
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) throw new IllegalStateException("there is no employee with this id");
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(Long id, String name, String email) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("there is no employee with id = " + id));
        if (name != null && name.length() > 0 && !Objects.equals(name, employee.getName())) employee.setName(name);
        if (email != null && email.length() > 0 && !Objects.equals(email, employee.getEmail())) {
            Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
            if (employeeOptional.isPresent()) throw new IllegalStateException("this email already exist");
            employee.setEmail(email);
        }
    }
}
