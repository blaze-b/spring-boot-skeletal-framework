package com.org.projectname.integration.dto;

import com.org.projectname.domain.EmployeeMaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDto {
    private List<EmployeeMaster> employeeMasters;
}
