package com.example.pharmacy.controller.item;

import com.example.pharmacy.model.item.Order;
import com.example.pharmacy.service.item.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/create")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Order>> listAll(String id) {
        return orderService.listAll(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> list(@PathVariable String id) {
        return orderService.list(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        return orderService.delete(id);
    }
}
