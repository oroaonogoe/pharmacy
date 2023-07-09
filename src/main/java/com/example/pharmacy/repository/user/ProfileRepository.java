package com.example.pharmacy.repository.user;

import com.example.pharmacy.model.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
