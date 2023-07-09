package com.example.pharmacy.controller.user;

import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.service.user.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/user/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping(value = "/create/{uuid}")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile, @PathVariable String uuid) {
        return profileService.createProfile(profile, uuid);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Profile>> getAllProfiles(String uuid) {
        return profileService.getAllProfiles(uuid);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<Profile> getOneProfile(@PathVariable String uuid) {
        return profileService.getOneProfile(uuid);
    }

    @PutMapping(value = "/update/{uuid}")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile, @PathVariable String uuid) {
        return profileService.updateProfile(profile, uuid);
    }

    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<Profile> deleteProfile(@PathVariable String uuid) {
        return profileService.deleteProfile(uuid);
    }
}
