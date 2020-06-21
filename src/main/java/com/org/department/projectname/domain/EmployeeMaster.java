package com.org.department.projectname.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_MASTER")
public class EmployeeMaster {

    @Id
    @SequenceGenerator(name = "EMPLOYEE_MASTER_SEQ", sequenceName = "EMPLOYEE_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "EMPLOYEE_MASTER_SEQ")
    @Column(name = "ID")
    private Long employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ORGANIZATION")
    private String organization;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "TARGET")
    private Integer target;

    @OneToOne(cascade = ALL, fetch = LAZY)
    @JoinColumn(name = "ROLE_ID")
    private EmployeeRoleMaster employeeRoleMaster;

    @OneToMany(cascade = ALL, fetch = LAZY)
    @JoinTable(name = "EMPLOYEE_GROUP_CHILD",
            joinColumns = {@JoinColumn(name = "EMP_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")}
    )
    private Set<EmployeeGroupMaster> employeeGroupMasters;

}


