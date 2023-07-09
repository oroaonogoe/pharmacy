package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    public ResponseEntity<Item> create(Item item);
    public ResponseEntity<List<Item>> listAll(String id);
    public ResponseEntity<Item> list(String id);
    public ResponseEntity<Item> update(String id, Item item);
    public ResponseEntity<HttpStatus> delete(String id);
}
