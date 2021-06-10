package com.saber.spring.rest.test.services.impl;

import com.saber.spring.rest.test.dto.EmployeeDto;
import com.saber.spring.rest.test.dto.EmployeeResponse;
import com.saber.spring.rest.test.entites.EmployeeEntity;
import com.saber.spring.rest.test.repositories.EmployeeRepository;
import com.saber.spring.rest.test.services.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public EmployeeEntity saveEmployee(EmployeeDto dto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(dto.getFirstName());
        employeeEntity.setLastName(dto.getLastName());
        employeeEntity.setMobile(dto.getMobile());
        employeeEntity.setAge(dto.getAge());
        employeeEntity.setSalary(dto.getSalary());
        return this.employeeRepository.save(employeeEntity);

    }

    @Override
    @Transactional
    public EmployeeResponse findAll() {
        List<EmployeeEntity> employeeEntities = this.employeeRepository.findAll();
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployees(employeeEntities);
        return response;
    }

    @Override
    @Transactional
    public EmployeeEntity updateEmployee(Integer id, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = findById(id);
        if (employeeEntity == null) {
            return null;
        }
        employeeEntity.setFirstName(employeeDto.getFirstName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setAge(employeeDto.getAge());
        employeeEntity.setMobile(employeeDto.getMobile());
        employeeEntity.setSalary(employeeDto.getSalary());
        return this.employeeRepository.save(employeeEntity);

    }

    @Override
    @Transactional
    public EmployeeEntity findById(Integer id) {
        return this.employeeRepository.findById(id).orElse(null);
    }
}
