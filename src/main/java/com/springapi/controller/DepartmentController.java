package com.springapi.controller;

import com.springapi.model.Department;
import com.springapi.response.DepartmentResponse;
import com.springapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentResponse> getDepartments() {
    }
}
