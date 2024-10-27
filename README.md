# Spring-boot-learning
## Prerequisite
- Install JAVA 23
- PostgreSQL 14
- pgadmin 4
- Node 
- Postman
- ReactJS

## Create a project
### Create Spring boot Project using Spring Initializer
- image1
### **application.yml**
```yml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/educate   # change the database name
    username: postgres                              # change the user name
    password: cyber@123                             # change the password
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect
```


