package com.org.projectname.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_ROLE_MASTER")
public class EmployeeRoleMaster {
    @Id
    @SequenceGenerator(name = "EMPLOYEE_ROLE_MASTER_SEQ", sequenceName = "EMPLOYEE_ROLE_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "EMPLOYEE_ROLE_MASTER_SEQ")
    @Column(name = "ID")
    private Long roleId;

    @Column(name = "NAME")
    private String roleName;
}
