package com.org.department.projectname.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String organizationName;
    @DateTimeFormat(pattern = "MM/DD/YYYY")
    private LocalDate dateOfBirth;
    private Integer target;
    private String employeeRole;
    private List<String> employeeGroups;
}
