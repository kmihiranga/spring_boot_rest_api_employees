package com.springapi.model;

import com.springapi.request.EmployeeRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employees")
public class Employee {
    //@JsonProperty("full_name")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name = "name")
    @NotNull(message = "Name should not be null")
    private String name;

    //@JsonIgnore // ignore this value from response
//    @Column(name = "age")
    private Long age = 0L;

//    @Column(name = "location")
    private String location;

//    @Column(name = "email")
    @Email(message = "Please enter a valid email address.")
    private String email;

//    @Column(name = "department")
//    @NotNull(message = "Department should not be null")
//    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

    public Employee(EmployeeRequest employeeRequest) {
        this.name = employeeRequest.getName();
        this.email = employeeRequest.getEmail();
        this.location = employeeRequest.getLocation();
        this.age = employeeRequest.getAge();
    }
}
