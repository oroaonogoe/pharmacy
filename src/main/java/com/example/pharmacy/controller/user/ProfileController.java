package com.example.pharmacy.controller.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.service.user.ProfileService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/user/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping(value = "/create/{uuid}")
    public ResponseEntity<Profile> create(@RequestBody Profile profile, @PathVariable String uuid) {
        return profileService.createProfile(profile, uuid);
    }

    @GetMapping(value = "/listAll")
    public ResponseEntity<List<Profile>> listAll(String id) {
        return profileService.getAllProfiles(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> one(@PathVariable String id) {
        return profileService.getProfile(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Profile> update(@PathVariable String id, @RequestBody Profile profile) {
        return profileService.updateProfile(id, profile);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        return profileService.deleteProfile(id);
    }

}
