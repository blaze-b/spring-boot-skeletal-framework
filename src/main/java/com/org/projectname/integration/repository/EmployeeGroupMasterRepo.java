package com.org.projectname.integration.repository;

import com.org.projectname.domain.EmployeeGroupMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeGroupMasterRepo extends JpaRepository<EmployeeGroupMaster, Long> {
    Optional<EmployeeGroupMaster> findByGroupName(String groupName);
}
