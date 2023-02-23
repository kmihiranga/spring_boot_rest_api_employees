package com.springapi.service;

import com.springapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByKeyWord(String keyword);

    List<Employee> getEmployeeByNameOrLocation(String name, String location);

    Integer deleteByEmployeeName(String name);

    List<Employee> getEmployeeByDepartmentName(String department);
}
