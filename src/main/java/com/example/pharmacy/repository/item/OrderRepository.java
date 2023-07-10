package com.example.pharmacy.repository.item;

import com.example.pharmacy.model.item.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
