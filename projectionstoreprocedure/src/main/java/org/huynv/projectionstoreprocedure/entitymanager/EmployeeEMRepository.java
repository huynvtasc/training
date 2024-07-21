package org.huynv.projectionstoreprocedure.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.huynv.projectionstoreprocedure.dto.EmployeeDto;
import org.huynv.projectionstoreprocedure.dto.IEmployeeDto;
import org.huynv.projectionstoreprocedure.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeEMRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Employee getEntity(String lastName) {
        return (Employee) entityManager.createQuery("from Employee e where e.lastName like :lastName")
                .setParameter("lastName", lastName)
                .getSingleResult();
    }

    public List<Employee> getEntities(String lastName) {
        return entityManager.createQuery("from Employee e where e.lastName like :lastName")
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<EmployeeDto> getDTOsTypeQuery() {
        TypedQuery<EmployeeDto> jpqlQuery = entityManager
                .createQuery("Select new org.huynv.projectionstoreprocedure.dto.EmployeeDto(e.firstName, e.lastName) " +
                        "from Employee e", EmployeeDto.class);
        List<EmployeeDto> employeeDto = jpqlQuery.getResultList();
        return employeeDto;
    }

    public EmployeeDto getDTOTypeQuery() {
        TypedQuery<EmployeeDto> jpqlQuery = entityManager
                .createQuery("Select new org.huynv.projectionstoreprocedure.dto.EmployeeDto(e.firstName, e.lastName) " +
                        "from Employee e", EmployeeDto.class);
        jpqlQuery.setMaxResults(1);
        return jpqlQuery.getSingleResult();
    }

    public Employee getProjection() {
        Query query = entityManager
                .createNativeQuery("select * from employee", Employee.class);
        query.setMaxResults(1);
        return (Employee) query.getSingleResult();
    }
}
