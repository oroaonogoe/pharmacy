package com.example.pharmacy.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmacy.model.user.Profile;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
