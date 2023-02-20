package com.springapi.service;

import com.springapi.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments(int pageNumber, int pageSize);

    Department saveDepartment(Department department);
}
