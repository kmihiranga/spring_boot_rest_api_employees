package com.springapi.service;

import com.springapi.model.Department;
import com.springapi.model.Employee;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments(int pageNumber, int pageSize);

    Department saveDepartment(Department department);
}
