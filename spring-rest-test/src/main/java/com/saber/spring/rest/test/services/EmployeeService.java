package com.saber.spring.rest.test.services;

import com.saber.spring.rest.test.dto.EmployeeDto;
import com.saber.spring.rest.test.dto.EmployeeResponse;
import com.saber.spring.rest.test.entites.EmployeeEntity;

public interface EmployeeService {
    EmployeeEntity saveEmployee(EmployeeDto dto);
    EmployeeResponse findAll();
    EmployeeEntity updateEmployee(Integer id,EmployeeDto employeeDto);
    EmployeeEntity findById(Integer id);
}
