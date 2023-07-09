package com.example.pharmacy.service.user.impl;

import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.model.user.User;
import com.example.pharmacy.repository.user.UserRepository;
import com.example.pharmacy.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Map<String, User> usersMap = new HashMap<>();

    @Override
    public ResponseEntity<User> createUser(User user) {
        try {
            Profile profile = new Profile();
            user.setProfile(profile);
            User _user = userRepository.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers(String uuid) {
        try {
            List<User> users = new ArrayList<>(usersMap.values());
            if (uuid == null)
                users.addAll(userRepository.findAll());
            else
                userRepository.findById(uuid);
            if (users.isEmpty())
                return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> getOneUser(String uuid) {
        try {
            Optional<User> userUuid = userRepository.findById(uuid);
            return userUuid.map(userV -> new ResponseEntity<>(userV, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> updateUser(User user, String uuid) {
        try {
            Optional<User> userUuid = userRepository.findById(uuid);
            if (userUuid.isPresent()) {
                User _user = userUuid.get();
                _user.setEmail(user.getEmail());
                _user.setPassword(user.getPassword());
                return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> deleteUser(String uuid) {
        try {
            userRepository.deleteById(uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
