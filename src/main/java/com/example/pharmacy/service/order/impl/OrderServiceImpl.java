package com.example.pharmacy.service.order.impl;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.model.order.Order;
import com.example.pharmacy.repository.item.ItemRepository;
import com.example.pharmacy.repository.order.OrderRepository;
import com.example.pharmacy.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<Order> createOrder(Order order) {
        try{
                return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders(String uuid) {
        try {
            List<Order> orders = new ArrayList<>();
            if (uuid == null)
                orders.addAll(orderRepository.findAll());
            else
                orderRepository.findById(uuid);
            if (orders.isEmpty())
                return new ResponseEntity<>(orders, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Order> getOneOrder(String uuid) {
        try{
            Optional<Order> id = orderRepository.findById(uuid);
            return id.map(order -> new ResponseEntity<>(order, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Override
//    public ResponseEntity<Order> updateOrder(Order order, String uuid) {
//        try {
//            Optional<Order> id = orderRepository.findById(uuid);
//            if (id.isPresent()){
//                Order ord = id.get();
//                ord.set
//            }
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @Override
    public ResponseEntity<Order> deleteOrder(String uuid) {
        try{
            orderRepository.deleteById(uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
