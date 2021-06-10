package com.saber.camel.spring.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class Employee implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer salary;
    private String mobile;
}