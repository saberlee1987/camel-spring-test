package com.saber.spring.rest.test.controllers;

import com.saber.spring.rest.test.dto.EmployeeDto;
import com.saber.spring.rest.test.dto.EmployeeResponse;
import com.saber.spring.rest.test.entites.EmployeeEntity;
import com.saber.spring.rest.test.services.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = this.employeeService.saveEmployee(employeeDto);
        return ResponseEntity.ok(employeeEntity);
    }
    @GetMapping
    public ResponseEntity<EmployeeResponse> findAll(){
        EmployeeResponse response= this.employeeService.findAll();
        return ResponseEntity.ok(response);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeEntity> findById(@PathVariable Integer id){
        EmployeeEntity employeeEntity = this.employeeService.findById(id);
        if (employeeEntity == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employeeEntity);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = this.employeeService.updateEmployee(id,employeeDto);
        if (employeeEntity == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employeeEntity);
    }
}
