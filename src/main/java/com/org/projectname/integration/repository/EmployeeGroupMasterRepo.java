package com.org.projectname.integration.repository;

import com.org.projectname.domain.EmployeeGroupMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeGroupMasterRepo extends JpaRepository<EmployeeGroupMaster, Long> {
    Optional<EmployeeGroupMaster> findByGroupNameIgnoreCase(String groupName);

    Set<EmployeeGroupMaster> findByGroupNameIgnoreCaseIn(List<String> groupNames);
}
