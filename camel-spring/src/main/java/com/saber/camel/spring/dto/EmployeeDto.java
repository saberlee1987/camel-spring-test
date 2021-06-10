package com.saber.camel.spring.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDto implements Serializable {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer salary;
    private String mobile;
}
