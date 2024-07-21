package org.huynv.projectionstoreprocedure.dto;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface IEmployeeDto3 {
    String getFirstName();
    String getLastName();
    List<AddressView> getAddresses();
    interface AddressView {
        String getProvince();
    }
}
