package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
    public ResponseEntity<Category> createCategory(Category category);
    public ResponseEntity<List<Category>> getAllCategories(String uuid);
    public ResponseEntity<Category> getOneCategory(String uuid);
    public ResponseEntity<Category> updateCategory(Category category, String uuid);
    public ResponseEntity<Category> deleteCategory(String uuid);
}
