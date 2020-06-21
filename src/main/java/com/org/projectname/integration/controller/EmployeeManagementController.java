package com.org.projectname.integration.controller;

import com.org.projectname.integration.dto.EmployeeDto;
import com.org.projectname.integration.dto.EmployeeGroupDto;
import com.org.projectname.integration.dto.EmployeeRoleDto;
import com.org.projectname.service.EmployeeManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/api/employee/management")
@Validated
@Api(value = "Employee Management Module", description = "Operations pertaining to the employee management")
public class EmployeeManagementController {

    private final EmployeeManagementService employeeManagementService;

    @Autowired
    public EmployeeManagementController(EmployeeManagementService employeeManagementService) {
        this.employeeManagementService = employeeManagementService;
    }

    @ApiOperation(value = "Api to create employee group details in the system")
    @ResponseStatus(CREATED)
    @PostMapping(value = "group/create")
    public void createEmployeeGroups(@Valid @RequestBody EmployeeGroupDto employeeGroupDto) {
        log.info("Entering the method to create some employees groups in the system with request body = {}",
                employeeGroupDto);
        employeeManagementService.createEmployeeGroup(employeeGroupDto.getEmployeeGroups());
    }

    @ApiOperation(value = "Api to create employee role detail in the system")
    @ResponseStatus(CREATED)
    @PostMapping(value = "role/create")
    public void createEmployeeRole(@Valid @RequestBody EmployeeRoleDto employeeRoleDto) {
        log.info("Entering the method to create some employees role in the system with request body = {}",
                employeeRoleDto);
        employeeManagementService.createEmployeeRole(employeeRoleDto.getEmployeeRoles());
    }

    @ApiOperation(value = "Api to create employee details in the system")
    @ResponseStatus(CREATED)
    @PostMapping(value = "employee/create")
    public void createEmployeeDetails(@Valid @RequestBody EmployeeDto employeeDto) {
        log.info("Entering the method to create some employees in the system with request body = {}", employeeDto);
        employeeManagementService.createEmployeeDetails(employeeDto);
    }

}
