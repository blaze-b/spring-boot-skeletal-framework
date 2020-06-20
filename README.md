# Spring Boot Skeletal Framework

- A small spring boot framework structure for easier building of JIT Rest Services
- Domain driven design pattern
- Consisting of flyway migration for easier SQL script management
- Sample Spring Data JPA repository
- Postgres SQL is the backend DB connection used for testing

# Api details to test

- API for creating the employee group </br>

&nbsp;&nbsp;POST /api/employee/management/group/create</br>
&nbsp;&nbsp;Host: localhost:8081</br>
&nbsp;&nbsp;Content-Type: application/json</br>
&nbsp;&nbsp;Request Body</br>
&nbsp;&nbsp;{</br>
&nbsp;&nbsp;&nbsp;"employeeGroups": [</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Group A",</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Group B",</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Group C",</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Group D"</br>
&nbsp;&nbsp;&nbsp;]</br>
&nbsp;&nbsp;}</br>