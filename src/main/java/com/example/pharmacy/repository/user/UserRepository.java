package com.example.pharmacy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmacy.model.user.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
