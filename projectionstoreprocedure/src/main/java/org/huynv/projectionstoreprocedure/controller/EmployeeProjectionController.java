package org.huynv.projectionstoreprocedure.controller;

import org.huynv.projectionstoreprocedure.dto.EmployeeDto;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto2;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto3;
import org.huynv.projectionstoreprocedure.entity.Address;
import org.huynv.projectionstoreprocedure.entity.Employee;
import org.huynv.projectionstoreprocedure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("projection/employees")
public class EmployeeProjectionController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/save")
    @Transactional
    public String save() {
        Address address = Address.builder()
                .province("TpHCM")
                .build();
        Employee employee = Employee.builder()
                .firstName("Tran")
                .lastName("Hieu")
                .addresses(List.of(address))
                .build();
        address.setEmployee(employee);
        employeeRepository.save(employee);
        return "Save successfully";
    }

//    @GetMapping("/entity")
//    public List<Employee> getEntity() {
//        return employeeRepository.findByFirstName("Nguyen");
//    }

//    @GetMapping("/dto1")
//    public List<EmployeeDto> getDto1() {
//        return employeeRepository.findByLastName("Huy");
//    }

    @GetMapping("/dto2") // findByLastName() -> ok -> interface projection
    public List<IEmployeeDto> getProjection() {
        return employeeRepository.findByLastName("Huy");
    }

    @GetMapping("/dto31") // findProjectionJPQL() -> null -> interface projection
    public List<IEmployeeDto> getProjectionJPQL() {
        return employeeRepository.findProjectionJPQL("Huy");
    }

    @GetMapping("/dto32") // findProjectionJPQL() -> ok -> interface projection
    public List<IEmployeeDto> getProjectionJPQL2() {
        return employeeRepository.findProjectionJPQL2("Huy");
    }

    @GetMapping("/dto41") // findProjectionNativeQuery() -> ok -> interface projection
    public List<IEmployeeDto> getProjectionNativeQuery() {
        return employeeRepository.findProjectionNativeQuery("Huy");
    }

    @GetMapping("/dto42") // findProjectionNativeQuery() -> ok -> interface projection
    public List<IEmployeeDto> getProjectionNativeQuery2() {
        return employeeRepository.findProjectionNativeQuery2("Huy");
    }

//    @GetMapping("/dto5") // findValueProjection() -> ok -> interface projection
//    public List<IEmployeeDto2> getValueProjection() {
//        return employeeRepository.findByFirstName("Nguyen"); // -> fullname: Nguyen Huy
//    }

    @GetMapping("/dto61") // findNestProjection() -> ok -> interface projection
    public List<IEmployeeDto3> getNestProjection() {
        return employeeRepository.findByFirstName("Nguyen");
    }

    @GetMapping("/dto62") // findNestProjection() -> ok -> interface projection
    public List<IEmployeeDto3> getNestProjection2() {
        return employeeRepository.findByFirstName2("Nguyen");
    }
}
