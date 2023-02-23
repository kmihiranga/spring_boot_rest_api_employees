package com.springapi.repository;

import com.springapi.model.Department;
import com.springapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long>, JpaRepository<Department, Long> {

}
