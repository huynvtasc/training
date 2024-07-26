package org.huynv.projectionstoreprocedure.controller;

import org.huynv.projectionstoreprocedure.entity.Employee;
import org.huynv.projectionstoreprocedure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saveandsaveflush")
public class SaveAndSaveAndFlushController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/save")
    public String save() {
        Employee employee = Employee.builder()
                .firstName("firstName")
                .lastName("lastName")
                .build();

        employeeRepository.save(employee);
        return "Save successfully !!!";
    }

    @GetMapping("/saveandflush")
    public String saveAndFlush() {
        Employee employee = Employee.builder()
                .firstName("firstName")
                .lastName("lastName")
                .build();

        employeeRepository.saveAndFlush(employee);
        return "Save successfully !!!";
    }


}
