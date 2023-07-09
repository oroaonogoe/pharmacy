package com.example.pharmacy.service.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.pharmacy.model.user.User;

@Component
public interface UserService {
    public ResponseEntity<User> createUser(User user);
    public ResponseEntity<List<User>> getAllUsers(String id);
    public ResponseEntity<User> getUser(String id);
    public ResponseEntity<User> updateUser(String id, User user);
    public ResponseEntity<HttpStatus> deleteUser(String id);
}
