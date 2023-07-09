package com.example.pharmacy.model.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    // hibernate version 4 and 5
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")

    // hibernate version 4 and 5 with IP and timestamp based UUID
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator",
    // parameters = {
    // @Parameter(name = "uuid_gen_strategy_class", value =
    // "org.hibernate.id.uuid.CustomVersionOneStrategy")
    // })

    // hibernate version 6
    // @Id
    // @GeneratedValue(generator = "uuid-generator")
    // @GenericGenerator(name = "uuid-generator", strategy = "UuidGenerator.class")
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "user_id")
    private String id;

    private String username;
    private String email;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
    @JsonManagedReference
    private Profile profile;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
