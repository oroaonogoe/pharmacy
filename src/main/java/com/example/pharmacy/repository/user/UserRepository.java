package com.example.pharmacy.repository.user;

import com.example.pharmacy.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
