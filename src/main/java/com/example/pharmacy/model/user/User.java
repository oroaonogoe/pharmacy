package com.example.pharmacy.model.user;

import java.time.LocalDateTime;
import java.util.List;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.model.item.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
    @JsonManagedReference(value = "user-profile")
    private Profile profile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference(value = "user-order")
    private List<Order> order;

    // constructor with no arguments
    public User() {
    }

    // constructor with arguments (parameterized constructor)
    // public User(String username, String email, String password) {
    // this.username = username;
    // this.email = email;
    // this.password = password;
    // }

    // getter and setter for all variables


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

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
