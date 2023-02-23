package com.springapi.controller;

import com.springapi.model.Department;
import com.springapi.model.Employee;
import com.springapi.request.EmployeeRequest;
import com.springapi.service.DepartmentServiceImpl;
import com.springapi.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private DepartmentServiceImpl departmentService;

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
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        Department department = new Department();
        department.setDepartmentName(employeeRequest.getDepartment());

        department = departmentService.saveDepartment(department);

        Employee employee = new Employee(employeeRequest);
        employee.setDepartment(department);

        employee = employeeService.saveEmployee(employee);

        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("Updating the employee data for the id " + id);
        employee.setId(Math.toIntExact(id));
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String keyword) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByKeyWord(keyword), HttpStatus.OK);
    }

    @GetMapping("/employees/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameOrLocation(name, location), HttpStatus.OK);
    }

    @DeleteMapping("/employees/delete/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name) {
        return new ResponseEntity<String>(employeeService.deleteByEmployeeName(name) + " of records deleted.", HttpStatus.OK);
    }

    @GetMapping("employees/filter/{department}")
    public ResponseEntity<List<Employee>> getEmployeeByDepartmentName(@PathVariable String department) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDepartmentName(department), HttpStatus.OK);
    }
}
