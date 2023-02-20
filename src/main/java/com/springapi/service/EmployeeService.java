package com.springapi.service;

import com.springapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);
}
