package com.example.pharmacy.service.item.impl;

import com.example.pharmacy.model.item.Category;
import com.example.pharmacy.repository.item.CategoryRepository;
import com.example.pharmacy.service.item.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<Category> createCategory(Category category) {
        try {
            Category _category = categoryRepository.save(category);
            return new ResponseEntity<>(_category, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories(String uuid) {
        try {
            List<Category> categoryId = new ArrayList<>();
            if (uuid == null) {
                categoryId.addAll(categoryRepository.findAll());
            } else {
                categoryRepository.findById(uuid);
            }
            if (categoryId.isEmpty())
                return new ResponseEntity<>(categoryId, HttpStatus.NOT_FOUND); //404
            return new ResponseEntity<>(categoryId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Category> getOneCategory(String uuid) {
        try {
            Optional<Category> categoryId = categoryRepository.findById(uuid);
            return categoryId.map(catV -> new ResponseEntity<>(catV, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Category> updateCategory(Category category, String uuid) {
        try {
            Optional<Category> categoryId = categoryRepository.findById(uuid);
            if (categoryId.isPresent()) {
                Category _category = categoryId.get();
                _category.setName(category.getName());
                return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Category> deleteCategory(String uuid) {
        categoryRepository.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
    }
}
