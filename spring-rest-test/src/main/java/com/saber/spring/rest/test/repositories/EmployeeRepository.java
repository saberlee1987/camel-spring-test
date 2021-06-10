package com.saber.spring.rest.test.repositories;

import com.saber.spring.rest.test.entites.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
 }
