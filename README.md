# Spring Boot Skeletal Framework

- A small spring boot framework structure for easier building of JIT Rest Services
- Domain driven design pattern
- Consisting of flyway migration for easier SQL script management
- Sample Spring Data JPA repository
- Postgres SQL is the backend DB connection used for testing

## Api details to test

- Swagger UI details </br>
![alt text](https://github.com/brianblaze14/spring-boot-skeletal-framework/blob/master/images/Swagger-api.PNG)

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

- Api for creating the employee role </br>

&nbsp;&nbsp;POST /api/employee/management/role/create</br>
&nbsp;&nbsp;Host: localhost:8081</br>
&nbsp;&nbsp;Content-Type: application/json</br>
&nbsp;&nbsp;Request body:</br>
&nbsp;&nbsp;{</br>
&nbsp;&nbsp;&nbsp;"employeeRoles": [</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Project Manager",</br>
&nbsp;&nbsp;&nbsp;&nbsp;"System Analyst",</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Senior Sofware Engineer",</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Software Engineer"</br>
&nbsp;&nbsp;&nbsp;]</br>
&nbsp;&nbsp;}</br>

- Api to create the employee details </br>

&nbsp;&nbsp;POST /api/employee/management/employee/create</br>
&nbsp;&nbsp;Host: localhost:8081</br>
&nbsp;&nbsp;Content-Type: application/json</br>
&nbsp;&nbsp;
&nbsp;&nbsp;{</br>
&nbsp;&nbsp;&nbsp;"dateOfBirth": "YYYY-MM-DD",</br>
&nbsp;&nbsp;&nbsp;"employeeGroups": [</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Group A",</br>
&nbsp;&nbsp;&nbsp;&nbsp;"Group B"</br>
&nbsp;&nbsp;&nbsp;],</br>
&nbsp;&nbsp;&nbsp;"employeeRole": "Senior Software Engineer",</br>
&nbsp;&nbsp;&nbsp;"firstName": "Bob",</br>
&nbsp;&nbsp;&nbsp;"lastName": "Marley",</br>
&nbsp;&nbsp;&nbsp;"organizationName": "XXXXXX",</br>
&nbsp;&nbsp;&nbsp;"target": 20</br>
&nbsp;&nbsp;}</br>

- Api to get all the employee details

&nbsp;&nbsp;GET /api/employee/management/employees </br>
&nbsp;&nbsp;Host: localhost:8081
