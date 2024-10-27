package com.educate.web.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String fullName;
    private String idNumber;
    private String password;
    private String role; // e.g., STUDENT, TEACHER, ADMIN
}
