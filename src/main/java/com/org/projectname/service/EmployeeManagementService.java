package com.org.projectname.service;

import com.org.projectname.domain.EmployeeGroupMaster;
import com.org.projectname.integration.dto.EmployeeDto;
import com.org.projectname.integration.errorhandler.exception.DuplicateValueException;
import com.org.projectname.integration.repository.EmployeeGroupMasterRepo;
import com.org.projectname.integration.repository.EmployeeMasterRepo;
import com.org.projectname.integration.repository.EmployeeRoleMasterRepo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

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

    public void createEmployeeGroup(List<String> employeeGroups) {
        log.info("Inside the method to create the employee group details in the system");
        employeeGroups.forEach(employeeGroup -> {
            Optional<EmployeeGroupMaster> employeeGroupMasterFromDb = employeeGroupMasterRepo.findByGroupName(employeeGroup);
            if (!employeeGroupMasterFromDb.isPresent()) {
                EmployeeGroupMaster employeeGroupMaster = new EmployeeGroupMaster();
                employeeGroupMaster.setGroupName(employeeGroup);
                employeeGroupMasterRepo.save(employeeGroupMaster);
            } else {
                throw new DuplicateValueException("The group name " + employeeGroup + " already exists in the system");
            }
        });
    }

    public void createEmployee(EmployeeDto employeeDto) {
        log.info("Inside the method to create the employee details in the system");
    }
}
