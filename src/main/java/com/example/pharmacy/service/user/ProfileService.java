package com.example.pharmacy.service.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.pharmacy.model.user.Profile;

public interface ProfileService {
    public ResponseEntity<Profile> createProfile(Profile profile, String uuid);
    public ResponseEntity<List<Profile>> getAllProfiles(String id);
    public ResponseEntity<Profile> getProfile(String id);
    public ResponseEntity<Profile> updateProfile(String id, Profile profile);
    ResponseEntity<HttpStatus> deleteProfile(String id);
}
