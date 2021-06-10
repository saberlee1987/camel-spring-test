package com.saber.spring.rest.test.dto;

import com.saber.spring.rest.test.entites.EmployeeEntity;
import lombok.Data;

import java.util.List;
@Data
public class EmployeeResponse {
    private List<EmployeeEntity> employees;
}
