package com.org.department.projectname.service;

import com.org.department.projectname.domain.EmployeeGroupMaster;
import com.org.department.projectname.domain.EmployeeMaster;
import com.org.department.projectname.domain.EmployeeRoleMaster;
import com.org.department.projectname.integration.dto.EmployeeDetailsDto;
import com.org.department.projectname.integration.dto.EmployeeDto;
import com.org.department.projectname.integration.errorhandler.exception.DuplicateValueException;
import com.org.department.projectname.integration.errorhandler.exception.ResourceNotFoundException;
import com.org.department.projectname.integration.repository.EmployeeGroupMasterRepo;
import com.org.department.projectname.integration.repository.EmployeeMasterRepo;
import com.org.department.projectname.integration.repository.EmployeeRoleMasterRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.data.domain.Sort.Direction.ASC;

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

    @Cacheable(value = "allEmployeeDetailsCache")
    public EmployeeDetailsDto getAllEmployeeDetails() {
        log.info("Inside the method to get all the employee details from the backend");
        List<EmployeeMaster> employeeMasters = employeeMasterRepo
                .findAll(Sort.by(ASC, "employeeId"));
        return new EmployeeDetailsDto(employeeMasters);
    }

    public void createEmployeeGroup(List<String> employeeGroups) {
        log.info("Inside the method to create the employee group details in the system");
        employeeGroups.forEach(employeeGroup -> {
            Optional<EmployeeGroupMaster> employeeGroupMasterFromDb = employeeGroupMasterRepo
                    .findByGroupNameIgnoreCase(employeeGroup);
            if (!employeeGroupMasterFromDb.isPresent()) {
                EmployeeGroupMaster employeeGroupMaster = new EmployeeGroupMaster();
                employeeGroupMaster.setGroupName(employeeGroup);
                employeeGroupMasterRepo.save(employeeGroupMaster);
            } else {
                throw new DuplicateValueException("The group name " + employeeGroup + " already exists in the system");
            }
        });
    }

    public void createEmployeeRole(List<String> employeeRoles) {
        log.info("Inside the method to create the employee role details in the system");
        employeeRoles.forEach(employeeRole -> {
            Optional<EmployeeRoleMaster> employeeRoleMasterFromDb = employeeRoleMasterRepo
                    .findByRoleNameIgnoreCase(employeeRole);
            if (!employeeRoleMasterFromDb.isPresent()) {
                EmployeeRoleMaster employeeRoleMaster = new EmployeeRoleMaster();
                employeeRoleMaster.setRoleName(employeeRole);
                employeeRoleMasterRepo.save(employeeRoleMaster);
            } else {
                throw new DuplicateValueException("The role name " + employeeRole + " already exists in the system");
            }
        });
    }

    public void createEmployeeDetails(EmployeeDto employeeDto) {
        log.info("Inside the method to create the employee details in the system");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setFirstName(employeeDto.getFirstName());
        employeeMaster.setLastName(employeeDto.getLastName());
        employeeMaster.setOrganization(employeeDto.getOrganizationName());
        employeeMaster.setDateOfBirth(employeeDto.getDateOfBirth());
        employeeMaster.setTarget(employeeDto.getTarget());
        EmployeeRoleMaster employeeRoleMasterFromDb = employeeRoleMasterRepo
                .findByRoleNameIgnoreCase(employeeDto.getEmployeeRole())
                .orElseThrow(() -> new ResourceNotFoundException("No Employee role details found in the system"));
        log.info("Employee role details from db = {}", employeeRoleMasterFromDb);
        employeeMaster.setEmployeeRoleMaster(employeeRoleMasterFromDb);
        Set<EmployeeGroupMaster> employeeGroup = employeeGroupMasterRepo
                .findByGroupNameIgnoreCaseIn(employeeDto.getEmployeeGroups());
        log.info("Employee group details from db = {}", employeeGroup);
        if (!CollectionUtils.isEmpty(employeeGroup)) {
            employeeMaster.setEmployeeGroupMasters(employeeGroup);
        } else {
            throw new ResourceNotFoundException("No Employee group details found in the system");
        }
        employeeMasterRepo.save(employeeMaster);
    }
}
