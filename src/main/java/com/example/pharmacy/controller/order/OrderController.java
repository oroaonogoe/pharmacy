package com.example.pharmacy.controller.order;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.model.order.Order;
import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.service.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Order>> getAllOrders(String uuid) {
        return orderService.getAllOrders(uuid);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<Order> getOneOrder(@PathVariable String uuid) {
        return orderService.getOneOrder(uuid);
    }

    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<Order> deleteOrder(@PathVariable String uuid) {
        return orderService.deleteOrder(uuid);
    }
}
