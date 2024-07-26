package org.huynv.projectionstoreprocedure.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public void callService(String string) {
        System.out.println("From service....: " + string);
    }

}
