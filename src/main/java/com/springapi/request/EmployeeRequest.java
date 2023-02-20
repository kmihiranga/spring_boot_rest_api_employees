package com.springapi.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {
    private String name;
    private Long age;

    private String location;

    private String email;

    private String department;
}
