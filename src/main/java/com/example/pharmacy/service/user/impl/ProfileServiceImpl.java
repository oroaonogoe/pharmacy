package com.example.pharmacy.service.user.impl;

import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.repository.user.ProfileRepository;
import com.example.pharmacy.service.user.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    Map<String, Profile> profileMap = new HashMap<>();

    @Override
    public ResponseEntity<Profile> createProfile(Profile profile, String uuid) {
        try {
            Optional<Profile> profileUuid = profileRepository.findById(uuid);
            if (profileUuid.isPresent()) {
                Profile _profile = profileUuid.get();
                _profile.setName(profile.getName());
                _profile.setDob(profile.getDob());
                return new ResponseEntity<>(profileRepository.save(_profile), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Profile>> getAllProfiles(String uuid) {
        try {
            List<Profile> profiles = new ArrayList<>(profileMap.values());
            if (uuid == null)
                profiles.addAll(profileRepository.findAll());
            else
                profileRepository.findById(uuid);
            if (profiles.isEmpty())
                return new ResponseEntity<>(profiles, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(profiles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Profile> getOneProfile(String uuid) {
        try {
            Optional<Profile> profileUuid = profileRepository.findById(uuid);
            return profileUuid.map(profileV -> new ResponseEntity<>(profileV, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Profile> updateProfile(Profile profile, String uuid) {
        try {
            Optional<Profile> profileUuid = profileRepository.findById(uuid);
            if (profileUuid.isPresent()) {
                Profile _profile = profileUuid.get();
                _profile.setName(profile.getName());
                _profile.setDob(profile.getDob());
                return new ResponseEntity<>(profileRepository.save(_profile), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Profile> deleteProfile(String uuid) {
        try {
            profileRepository.deleteById(uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
