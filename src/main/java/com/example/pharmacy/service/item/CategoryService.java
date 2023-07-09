package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    public ResponseEntity<Category> create(Category category);
    public ResponseEntity<List<Category>> listAll(String id);
    public ResponseEntity<Category> list(String id);
    public ResponseEntity<Category> update(String id, Category category);
    public ResponseEntity<HttpStatus> delete(String id);
}
