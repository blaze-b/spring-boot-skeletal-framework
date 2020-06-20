package com.org.projectname.config;

import com.org.projectname.integration.repository.EmployeeGroupMasterRepo;
import com.org.projectname.integration.repository.EmployeeMasterRepo;
import com.org.projectname.integration.repository.EmployeeRoleMasterRepo;
import com.org.projectname.service.EmployeeManagementService;
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
