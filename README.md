# Spring-boot-learning
### Prerequisite
- Install JAVA 17
- PostgreSQL 14
- pgadmin 4
- Node 21
- Postman

### Create Spring boot Project using `Spring Initializer`
- Create a project using [Spring Initializer](https://start.spring.io/)
![image](https://github.com/user-attachments/assets/f74f6f9d-d071-48d7-9464-4b873b6360ed)

### Project Structure
![image](https://github.com/user-attachments/assets/9498681d-7ef6-43de-8afe-f9f0703f2d80)

`Node:` Delete the application.properties and create `application.yml`
### Project Code:
**build.gradle**
```gradle
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.3.1'
	id 'io.spring.dependency-management' version '1.1.5'
}

group = 'com.sample'
version = '0.0.1-SNAPSHOT'

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'org.postgresql:postgresql'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
	useJUnitPlatform()
}

```
**application.yml**

```yml
spring:
    datasource:
        url: jdbc:postgresql://localhost:5432/Training
        username: postgres
        password: admin
        driver-class-name: org.postgresql.Driver
    jpa:
        hibernate:
            ddl-auto: update
        show-sql: true
        properties:
            hibernate:
                format_sql: false
        database-platform: org.hibernate.dialect.PostgreSQLDialect

server:
    port: 8080
```
**DemoappApplication.java <-- Root of the Project.**
```java
package com.sample.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoappApplication.class, args);
		System.out.println("http://localhost:8080/");
	}

}
```
**UserController.java**
```java
package com.sample.demoapp.controller;

import com.sample.demoapp.model.UserModel;
import com.sample.demoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor injection (best to use).
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        UserModel user = userService.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

```
**UserModel.java**
```java
package com.sample.demoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class package com.sample.demoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    
}
 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    
}

```
**UserRepository.java**
```java
package com.sample.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sample.demoapp.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByEmail(String email);
}

```
**UserService.java**
```java
package com.sample.demoapp.service;

import com.sample.demoapp.model.UserModel;

public interface UserService {
    
    UserModel findByEmail(String email);
    
}

```
**UserServiceImpl.java**
```java
package com.sample.demoapp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demoapp.model.UserModel;
import com.sample.demoapp.repository.UserRepository;
import com.sample.demoapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    // Field injection
    @Autowired
    UserRepository userRepository;


    // Implementation findByEmail function in UserService class.
    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

```

`Note:` Database username `postgres`, password `admin` 
![image](https://github.com/user-attachments/assets/a0525fa2-4311-4c28-ba77-0aac8e88c3dc)
`Note:` Table must have one record.
### Output
![image](https://github.com/user-attachments/assets/4e85f337-0dd5-4b88-b5a9-408e9c145a07)



# Thank you...
