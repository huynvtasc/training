package org.huynv.projectionstoreprocedure.dto;

import org.springframework.beans.factory.annotation.Value;

public interface IEmployeeDto2 {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
