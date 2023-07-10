package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    public ResponseEntity<Order> create(Order order);
    public ResponseEntity<List<Order>> listAll(String id);
    public ResponseEntity<Order> list(String id);
    public ResponseEntity<HttpStatus> delete(String id);
}
