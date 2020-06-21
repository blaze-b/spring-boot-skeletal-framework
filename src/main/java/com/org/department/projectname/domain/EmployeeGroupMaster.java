package com.org.department.projectname.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_GROUP_MASTER")
public class EmployeeGroupMaster implements Serializable {
    @Id
    @SequenceGenerator(name = "EMPLOYEE_GROUP_MASTER_SEQ", sequenceName = "EMPLOYEE_GROUP_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "EMPLOYEE_GROUP_MASTER_SEQ")
    @Column(name = "ID")
    private Long groupId;

    @Column(name = "NAME")
    private String groupName;
}