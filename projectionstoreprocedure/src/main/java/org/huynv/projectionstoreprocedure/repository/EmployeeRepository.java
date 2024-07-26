package org.huynv.projectionstoreprocedure.repository;

import org.huynv.projectionstoreprocedure.dto.EmployeeDto;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto2;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto3;
import org.huynv.projectionstoreprocedure.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    List<Employee> findByFirstName(String firstName);
//    @Query("SELECT new org.huynv.projectionstoreprocedure.dto.EmployeeDto(e.firstName, e.lastName) " +
//            "FROM Employee e " +
//            "WHERE e.lastName = :lastName")
//    List<EmployeeDto> findByLastName(String lastName);

//    List<IEmployeeDto> findByLastName(String lastName);
    @Query("SELECT e.firstName AS firstName, e.lastName AS lastName " +
            "FROM Employee e " +
            "WHERE e.lastName = :lastName")
    List<IEmployeeDto> findProjectionJPQL(String lastName);

    @Query("SELECT e " +
            "FROM Employee e " +
            "WHERE e.lastName = :lastName")
    List<IEmployeeDto> findProjectionJPQL2(String lastName);

    @Query(value = "SELECT e.first_name, e.last_name " +
            "FROM employee e " +
            "WHERE e.last_name = :lastName", nativeQuery = true)
    List<IEmployeeDto> findProjectionNativeQuery(String lastName);

    @Query(value = "SELECT e.* " +
            "FROM employee e " +
            "WHERE e.last_name = :lastName", nativeQuery = true)
    List<IEmployeeDto> findProjectionNativeQuery2(String lastName);

//    List<IEmployeeDto2> findByFirstName(String firstName);

    List<IEmployeeDto3> findByFirstName(String firstName);

    @Query("SELECT e " +
            "FROM Employee e " +
            "WHERE e.lastName = :lastName")
    List<IEmployeeDto3> findByFirstName2(String lastName);

    @Procedure(name = "Employee.getEmployeeByProcedure")
    Employee getEmployeeByProcedure(@Param("lastName") String lastName);
}