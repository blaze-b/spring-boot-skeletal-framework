package com.org.department.projectname.config;

import com.org.department.projectname.service.EmployeeManagementService;
import com.org.department.projectname.integration.repository.EmployeeGroupMasterRepo;
import com.org.department.projectname.integration.repository.EmployeeMasterRepo;
import com.org.department.projectname.integration.repository.EmployeeRoleMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Autowired
    private EmployeeGroupMasterRepo employeeGroupMasterRepo;
    @Autowired
    private EmployeeMasterRepo employeeMasterRepo;
    @Autowired
    private EmployeeRoleMasterRepo employeeRoleMasterRepo;

    @Bean
    public EmployeeManagementService employeeManagementService() {
        return new EmployeeManagementService(employeeGroupMasterRepo, employeeMasterRepo, employeeRoleMasterRepo);
    }
}
