package com.example.pharmacy.service.user;

import com.example.pharmacy.model.user.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProfileService {

    public ResponseEntity<Profile> createProfile(Profile profile, String uuid);
    public ResponseEntity<List<Profile>> getAllProfiles(String uuid);
    public ResponseEntity<Profile> getOneProfile(String uuid);
    public ResponseEntity<Profile> updateProfile(Profile profile, String uuid);
    public ResponseEntity<Profile> deleteProfile(String uuid);
}
