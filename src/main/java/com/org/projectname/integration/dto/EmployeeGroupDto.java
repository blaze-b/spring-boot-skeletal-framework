package com.org.projectname.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGroupDto {
    @NotEmpty
    private List<String> employeeGroups;
}
