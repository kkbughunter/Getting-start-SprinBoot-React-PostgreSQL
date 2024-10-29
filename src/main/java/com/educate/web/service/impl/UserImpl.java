package com.educate.web.service.impl;

import com.educate.web.dto.UserDTO;
import com.educate.web.model.User;
import com.educate.web.repository.UserRepo;
import com.educate.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerUser(UserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setIdNumber(userDTO.getIdNumber());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return userRepo.save(user);
    }

    @Override
    public User loginUser(String idNumber, String password) {
        try {
            return userRepo.findByIdNumber(idNumber)
                    .filter(user -> user.getPassword().equals(password))
                    .orElseThrow(() -> new RuntimeException("Invalid idNumber or password"));
        } catch (Exception e) {
            throw e;
        }
    }

}
