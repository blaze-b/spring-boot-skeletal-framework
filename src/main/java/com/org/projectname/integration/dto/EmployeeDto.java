package com.org.projectname.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String employeeName;
    @DateTimeFormat(pattern = "MM/DD/YYYY")
    private LocalDate dateOfBirth;
    private Integer target;
    private String employeeRole;
    private List<String> employeeGroups;
}
