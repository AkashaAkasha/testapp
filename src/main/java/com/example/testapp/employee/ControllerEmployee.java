package com.example.testapp.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ControllerEmployee {
    ServiceEmployee serviceEmployee;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return serviceEmployee.getAllEmployee();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return serviceEmployee.saveEmployee(employee);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable Long id){
        serviceEmployee.deleteEmployee(id);
    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable Long id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email) {
        serviceEmployee.updateEmployee(id, name, email);

    }
}
