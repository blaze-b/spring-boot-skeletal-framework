# Spring Boot Skeletal Framework

- A small spring boot framework structure for easier building of JIT Rest Services
- Domain driven design pattern
- Consisting of flyway migration for easier SQL script management
- Sample Spring Data JPA repository
- Postgres SQL is the backend DB connection used for testing

# Api details to test

- API for creating the employee group </br>

POST /api/employee/management/group/create</br>
Host: localhost:8081</br>
Content-Type: application/json</br>
Request Body</br>
{</br>
  "employeeGroups": [</br>
    "Group A",</br>
    "Group B",</br>
    "Group C",</br>
    "Group D"</br>
  ]</br>
}</br>