package com.springapi.service;

import com.springapi.model.Employee;
import com.springapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");
        return employeeRepository.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id " + id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeesByKeyWord(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return employeeRepository.findByNameContaining(name, sort);
    }

    @Override
    public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
        return employeeRepository.getEmployeeByNameAndLocation(name, location);
    }

    @Override
    public Integer deleteByEmployeeName(String name) {
        return employeeRepository.deleteEmployeeByName(name);
    }

    @Override
    public List<Employee> getEmployeeByDepartmentName(String department) {
        return employeeRepository.getEmployeeByDepartmentName(department);
    }
}
