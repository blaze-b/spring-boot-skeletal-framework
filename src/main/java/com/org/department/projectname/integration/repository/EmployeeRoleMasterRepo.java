package com.org.department.projectname.integration.repository;

import com.org.department.projectname.domain.EmployeeRoleMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRoleMasterRepo extends JpaRepository<EmployeeRoleMaster, Long> {
    Optional<EmployeeRoleMaster> findByRoleNameIgnoreCase(String roleName);
}
