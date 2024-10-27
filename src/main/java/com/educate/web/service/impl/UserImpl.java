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
        user.setPassword(userDTO.getPassword()); // Consider hashing the password
        user.setRole(userDTO.getRole());
        return userRepo.save(user);
    }

    @Override
    public User loginUser(String idNumber, String password) {
        Optional<User> userOptional = userRepo.findByIdNumber(idNumber);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional.get();
        }
        return null; // Handle invalid login attempt
    }
}
