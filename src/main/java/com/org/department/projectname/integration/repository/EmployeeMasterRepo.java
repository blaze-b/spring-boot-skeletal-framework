package com.org.department.projectname.integration.repository;

import com.org.department.projectname.domain.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeMasterRepo extends JpaRepository<EmployeeMaster, Long> {
}
