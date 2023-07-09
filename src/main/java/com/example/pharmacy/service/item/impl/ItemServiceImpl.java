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
    public ResponseEntity<Item> createItem(Item item) {
        try {
            Item _item = itemRepository.save(item);
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Item>> getAllItems(String uuid) {
        try {
            List<Item> items = new ArrayList<>();
            if (uuid == null)
                items.addAll(itemRepository.findAll());
            else
                itemRepository.findById(uuid);
            if (items.isEmpty())
                return new ResponseEntity<>(items, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Item> getOneItem(String uuid) {
        try {
            Optional<Item> itemUuid = itemRepository.findById(uuid);
            return itemUuid.map(itemV -> new ResponseEntity<>(itemV, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Item> updateItem(Item item, String uuid) {
        try{
            Optional<Item> itemUuid = itemRepository.findById(uuid);
            if (itemUuid.isPresent()){
                Item _item = itemUuid.get();
                _item.setName(item.getName());
                _item.setCategory(item.getCategory());
                return new ResponseEntity<>(itemRepository.save(_item), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Item> deleteItem(String uuid) {
        try {
            itemRepository.deleteById(uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
