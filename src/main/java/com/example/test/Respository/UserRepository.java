package com.example.test.Respository;

import com.example.test.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository   <User,Long> {

    Optional<User> findByUsername(String username);
}
