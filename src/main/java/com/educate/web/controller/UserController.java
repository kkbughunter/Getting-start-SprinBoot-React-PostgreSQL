package com.educate.web.controller;

import com.educate.web.dto.UserDTO;
import com.educate.web.model.User;
import com.educate.web.service.UserService;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User registeredUser = userService.registerUser(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/getin")
    public ResponseEntity<User> loginUser(@RequestBody Map<String, String> loginData) {
        String idNumber = loginData.get("idNumber");
        String password = loginData.get("password");

        User loggedInUser = userService.loginUser(idNumber, password);
        return ResponseEntity.ok(loggedInUser);
    }

}
