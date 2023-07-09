package com.example.pharmacy.service.user.impl;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.repository.user.ProfileRepository;
import com.example.pharmacy.service.user.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    Map<String, Profile> _profiles = new HashMap<>();

    @Override
    public ResponseEntity<Profile> createProfile(Profile profile, String uuid) {
        try {
            Optional<Profile> profileID = profileRepository.findById(uuid);
            if (profileID.isPresent()) {
                Profile _profile = profileID.get();
                _profile.setName(profile.getName());
                _profile.setDob(profile.getDob());
                return new ResponseEntity<Profile>(profileRepository.save(_profile), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Profile>> getAllProfiles(String id) {
        try {
            List<Profile> profiles = new ArrayList<Profile>(_profiles.values());
            if (id == null) {
                profiles.addAll(profileRepository.findAll());
            } else {
                profileRepository.findById(id);
            }

            if (profiles.isEmpty()) {
                return new ResponseEntity<List<Profile>>(profiles, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Profile>>(profiles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Profile>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Profile> getProfile(String id) {
        try {
            Optional<Profile> _profile = profileRepository.findById(id);

//        if(_profile.isPresent()) {
//            return new ResponseEntity<>(_profile.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

            return _profile.map(profile -> new ResponseEntity<Profile>(profile, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Profile> updateProfile(String id, Profile profile) {
        try {
            Optional<Profile> _profile = profileRepository.findById(id);

            if (_profile.isPresent()) {
                Profile updateProfile = _profile.get();
                updateProfile.setName(profile.getName());
                updateProfile.setDob(profile.getDob());
                return new ResponseEntity<Profile>(profileRepository.save(updateProfile), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteProfile(String id) {
        try {
            profileRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
