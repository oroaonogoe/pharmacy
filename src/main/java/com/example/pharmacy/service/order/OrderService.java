package com.example.pharmacy.service.order;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.model.order.Order;
import com.example.pharmacy.repository.order.OrderRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    public ResponseEntity<Order> createOrder(Order order);
    public ResponseEntity<List<Order>> getAllOrders(String uuid);
    public ResponseEntity<Order> getOneOrder(String uuid);
//    public ResponseEntity<Order> updateOrder(Order order, String uuid);
    public ResponseEntity<Order> deleteOrder(String uuid);
}
