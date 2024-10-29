package com.educate.web.service;

import com.educate.web.dto.UserDTO;
import com.educate.web.model.User;

public interface UserService {
    User registerUser(UserDTO userDTO);
    User loginUser(String idNumber, String password);

}
