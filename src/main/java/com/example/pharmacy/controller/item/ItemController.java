package com.example.pharmacy.controller.item;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.service.item.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Item>> getAllItems(String uuid) {
        return itemService.getAllItems(uuid);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<Item> getOneItem(@PathVariable String uuid) {
        return itemService.getOneItem(uuid);
    }

    @PutMapping(value = "/update/{uuid}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable String uuid) {
        return itemService.updateItem(item, uuid);
    }

    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<Item> deleteItem(@PathVariable String uuid) {
        return itemService.deleteItem(uuid);
    }
}
