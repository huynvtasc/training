package org.huynv.projectionstoreprocedure.controller;

import org.huynv.projectionstoreprocedure.dao.EmployeeDao;
import org.huynv.projectionstoreprocedure.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdbctemplate")
public class EmployeeJdbcTemplateController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/count")
    public int count() {
        return employeeDao.count_();
    }

    @GetMapping("/getbyid")
    public Employee getById() {
        return employeeDao.getById();
    }
}
