package com.springapi.controller;

import com.springapi.model.Employee;
import com.springapi.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    // read property names inside application.properties file
//    @Value("${app.name}")
//    private String appName;
//
//    @Value("${app.version}")
//    private String appVersion;
//
//    @GetMapping("/api/version")
//    public String getAppName() {
//        return appName + " - " + appVersion;
//    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("Updating the employee data for the id " + id);
        employee.setId(Math.toIntExact(id));
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long id) {
        System.out.println("Employee deleted by id " + id);
        employeeService.deleteEmployee(id);
    }
}
