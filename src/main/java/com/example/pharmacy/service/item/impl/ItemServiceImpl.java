package com.example.pharmacy.service.item.impl;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.repository.item.ItemRepository;
import com.example.pharmacy.service.item.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<Item> create(Item item) {
        try {
            return new ResponseEntity<>(itemRepository.save(item), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Item>> listAll(String id) {
        try {
            List<Item> _item = new ArrayList<>();
            if (id == null) {
                _item.addAll(itemRepository.findAll());
            } else {
                itemRepository.findById(id);
            }
            if (_item.isEmpty()) {
                return new ResponseEntity<>(_item, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(_item, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Item> list(String id) {
        try {
            Optional<Item> _item = itemRepository.findById(id);
            return _item.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Item> update(String id, Item item) {
        try {
            Optional<Item> _item = itemRepository.findById(id);
            if (_item.isPresent()) {
                Item items = _item.get();
                items.setName(item.getName());
                return new ResponseEntity<>(itemRepository.save(items), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> delete(String id) {
        try {
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
