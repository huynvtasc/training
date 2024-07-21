package org.huynv.projectionstoreprocedure.controller;

import org.huynv.projectionstoreprocedure.dto.EmployeeDto;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto;
import org.huynv.projectionstoreprocedure.entity.Employee;
import org.huynv.projectionstoreprocedure.entitymanager.EmployeeEMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("projection/em/employees")
public class EntityManagerController {
    @Autowired
    EmployeeEMRepository employeeEMRepository;

    @GetMapping("/getentity")
    public Employee getEntity() {
        return employeeEMRepository.getEntity("Huy");
    }

    @GetMapping("/getentities")
    public List<Employee> getEntities() {
        return employeeEMRepository.getEntities("Huy");
    }

    @GetMapping("/getDTOsTypeQuery")
    public List<EmployeeDto> getDTOsTypeQuery() {
        return employeeEMRepository.getDTOsTypeQuery();
    }

    @GetMapping("/getDTOTypeQuery")
    public EmployeeDto getDTOTypeQuery() {
        return employeeEMRepository.getDTOTypeQuery();
    }

    @GetMapping("/getProjection")
    public Employee getProjection() {
        return employeeEMRepository.getProjection();
    }
}
