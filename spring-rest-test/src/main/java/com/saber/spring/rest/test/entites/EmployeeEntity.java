package com.saber.spring.rest.test.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstName",length = 60)
    private String firstName;
    @Column(name = "lastName",length = 80)
    private String lastName;
    private Integer age;
    private Long salary;
    @Column(name = "mobile",length = 15)
    private String mobile;
}
