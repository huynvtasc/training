package org.huynv.projectionstoreprocedure.controller;

import lombok.Getter;
import org.huynv.projectionstoreprocedure.entity.Employee;
import org.huynv.projectionstoreprocedure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("procedure/employees")
public class EmployeeProcedureController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    @Transactional
    public Employee getEmployeeByProcedure() {
        return employeeRepository.getEmployeeByProcedure("Huy");
    }
}
