package com.example.pharmacy.model.order;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "order_id")
    private String id;

    @CreationTimestamp
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "order-user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference(value = "order-item")
    private Item item;
    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
