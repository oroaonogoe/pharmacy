package com.example.pharmacy.controller.user;

import com.example.pharmacy.model.user.User;
import com.example.pharmacy.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> getAllUsers(String uuid){
        return userService.getAllUsers(uuid);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<User> getOneUser(@PathVariable String uuid){
        return userService.getOneUser(uuid);
    }

    @PutMapping(value = "/update/{uuid}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String uuid){
        return userService.updateUser(user, uuid);
    }

    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<User> deleteUser(@PathVariable String uuid){
        return userService.deleteUser(uuid);
    }
}
