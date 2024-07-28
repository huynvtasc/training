package org.huynv.projectionstoreprocedure.dao;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.huynv.projectionstoreprocedure.dto.EmployeeDto;
import org.huynv.projectionstoreprocedure.entity.Address;
import org.huynv.projectionstoreprocedure.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeDao {
    JdbcTemplate jdbcTemplate;

    public int count() {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee", Integer.class);
        return result;
    }

    public int count_() {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee WHERE id = ?", Integer.class, 2L);
        return result;
    }

    public int count__() {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee WHERE id = ?", new Object[]{2L}, Integer.class);
        return result;
    }

    public Employee getById() {
        Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employee e WHERE id = ?",
                new Object[]{2L},
                new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Employee employee1 = new Employee();
                        employee1.setId(rs.getLong("id"));
                        employee1.setFirstName(rs.getString("first_name"));
                        employee1.setLastName(rs.getString("last_name"));
                        return employee1;
                    }
                });
        List<Address> addresses = jdbcTemplate.query("SELECT * FROM address a WHERE emp_id = ?",
                new Object[]{2L},
                new RowMapper<Address>() {
                    @Override
                    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Address address = new Address();
                        address.setId(rs.getLong("id"));
                        address.setProvince(rs.getString("province"));
                        return address;
                    }
                });
        employee.setAddresses(addresses);
        return employee;
    }

    public Employee test() {
        return jdbcTemplate.
    }
}
