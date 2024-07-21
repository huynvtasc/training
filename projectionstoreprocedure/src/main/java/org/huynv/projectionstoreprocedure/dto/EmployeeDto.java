package org.huynv.projectionstoreprocedure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDto {
    private String firstName; // nhan xet: khong can alias, chi can dung vi tri khi select new dto()
    private String lastName;
}
