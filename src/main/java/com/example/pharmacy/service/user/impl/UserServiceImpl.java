package com.example.pharmacy.service.user.impl;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.model.user.User;
import com.example.pharmacy.repository.user.UserRepository;
import com.example.pharmacy.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Map<String, User> userMap = new HashMap<>();

    @Override
    public ResponseEntity<User> createUser(User user) {
        try {
            Profile _profile = new Profile();
            user.setProfile(_profile);
            User _user = userRepository.save(user);
            return new ResponseEntity<User>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers(String id) {
        try {
            List<User> users = new ArrayList<>(userMap.values());
            if (id == null) users.addAll(userRepository.findAll());
            else userRepository.findById(id);

            if (users.isEmpty()) return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> getUser(String id) {
        try {
            Optional<User> _user = userRepository.findById(id);
//        if (_user.isPresent()) {
//            return new ResponseEntity<>(_user.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }

            return _user.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> updateUser(String id, User user) {
        try {
            Optional<User> _user = userRepository.findById(id);

            if (_user.isPresent()) {
                User updateUser = _user.get();
                updateUser.setEmail(user.getEmail());
                updateUser.setPassword(user.getPassword());
                return new ResponseEntity<>(userRepository.save(updateUser), HttpStatus.OK);
            } else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteUser(String id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
