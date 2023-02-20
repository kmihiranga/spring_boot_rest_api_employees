package com.springapi.repository;

import com.springapi.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.Location;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, JpaRepository<Employee, Long> {
    // this is a custom query method - use field name with findBy
    List<Employee> findByName(String name);

    // select * from table where name="kalana" and location="panadura"
    List<Employee> findByNameAndLocation(String name, String location);

    // select * from table where name LIKE "%ram%"
    List<Employee> findByNameContaining(String keyword, Sort sort);

    // List<Employee> findByNameLike(String "%" + keyword + "%"); second way

    @Query("FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeeByNameAndLocation(String name, String location);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name = :name")
    Integer deleteEmployeeByName(String name);
}
