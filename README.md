# employee-management-system
 CRUD (Create, Read, Update, Delete) Web Application using Angular 7 as a front-end and Spring boot 2 restful API as a backend.



## Create MySql docker container
docker run --name mysql-ems -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=users_database -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=Passw0rd -p 3306:3306 -d mysql/mysql-server:latest

(Need to include in docker compose/helm chart)


# API endpoint
<host>:9000/api/v1/employees


# Angular
## Components
create-employee
employee-list
employee-details
## Services
employee.service.ts - Service for Http Client methods
## Modules
FormsModule
HttpClientModule
AppRoutingModule.
## Employee Class (Typescript class)
employee.ts: class Employee (id, firstName, lastName, emailId)