package com.example.pharmacy.repository.order;

import com.example.pharmacy.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
