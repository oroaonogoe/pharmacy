package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemService {
    public ResponseEntity<Item> createItem(Item item);
    public ResponseEntity<List<Item>> getAllItems(String uuid);

    public ResponseEntity<Item> getOneItem(String uuid);
    public ResponseEntity<Item> updateItem(Item item, String uuid);

    public ResponseEntity<Item> deleteItem(String uuid);
}
