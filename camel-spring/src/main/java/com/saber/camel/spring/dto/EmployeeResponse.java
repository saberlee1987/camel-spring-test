package com.saber.camel.spring.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class EmployeeResponse implements Serializable {
    private List<Employee> employees;
}
