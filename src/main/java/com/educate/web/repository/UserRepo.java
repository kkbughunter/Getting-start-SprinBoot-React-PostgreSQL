package com.educate.web.repository;

import com.educate.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByIdNumber(String idNumber);
}
