package com.example.pharmacy.controller.item;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.service.item.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/api/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        return itemService.create(item);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Item>> listAll(String id) {
        return itemService.listAll(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> list(@PathVariable String id) {
        return itemService.list(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> update(@PathVariable String id, @RequestBody Item item) {
        return itemService.update(id, item);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        return itemService.delete(id);
    }

}
