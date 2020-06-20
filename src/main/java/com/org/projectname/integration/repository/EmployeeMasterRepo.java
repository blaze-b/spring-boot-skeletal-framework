package com.org.projectname.integration.repository;

import com.org.projectname.domain.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeMasterRepo extends JpaRepository<EmployeeMaster, Long> {
}
