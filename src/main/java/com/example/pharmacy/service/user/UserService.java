package com.example.pharmacy.service.user;

import com.example.pharmacy.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    public ResponseEntity<User> createUser(User user);
    public ResponseEntity<List<User>> getAllUsers(String uuid);
    public ResponseEntity<User> getOneUser(String uuid);

    public ResponseEntity<User> updateUser(User user, String uuid);
    public ResponseEntity<User> deleteUser(String uuid);
}
