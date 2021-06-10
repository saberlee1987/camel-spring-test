package com.saber.spring.rest.test.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private Long salary;
    private String mobile;
}
