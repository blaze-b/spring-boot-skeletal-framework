package com.org.projectname.service;

import com.org.projectname.integration.repository.EmployeeGroupMasterRepo;
import com.org.projectname.integration.repository.EmployeeMasterRepo;
import com.org.projectname.integration.repository.EmployeeRoleMasterRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeManagementService {
    private final EmployeeGroupMasterRepo employeeGroupMasterRepo;
    private final EmployeeMasterRepo employeeMasterRepo;
    private final EmployeeRoleMasterRepo employeeRoleMasterRepo;

    public EmployeeManagementService(EmployeeGroupMasterRepo employeeGroupMasterRepo,
                                     EmployeeMasterRepo employeeMasterRepo,
                                     EmployeeRoleMasterRepo employeeRoleMasterRepo) {
        this.employeeGroupMasterRepo = employeeGroupMasterRepo;
        this.employeeMasterRepo = employeeMasterRepo;
        this.employeeRoleMasterRepo = employeeRoleMasterRepo;
    }
}
