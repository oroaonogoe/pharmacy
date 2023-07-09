package com.example.pharmacy.controller.user;

import org.springframework.web.bind.annotation.*;

import com.example.pharmacy.model.user.User;
import com.example.pharmacy.service.user.UserService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value="/listAll")
    public ResponseEntity<List<User>> listAll(String id) {
        return userService.getAllUsers(id);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> one(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        return userService.deleteUser(id);
    }
    
    
}
