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

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<Category> create(Category category) {
        try {
            Category _cag = categoryRepository.save(category);
            return new ResponseEntity<>(_cag, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Category>> listAll(String id) {
        try {
            List<Category> _cag = new ArrayList<>();
            if (id == null) {
                _cag.addAll(categoryRepository.findAll());
            } else {
                categoryRepository.findById(id);
            }
            if (_cag.isEmpty()) {
                return new ResponseEntity<>(_cag, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(_cag, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Category> list(String id) {
        try {
            Optional<Category> _cag = categoryRepository.findById(id);
            return _cag.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Category> update(String id, Category category) {
        try {
            Optional<Category> _cag = categoryRepository.findById(id);
            if (_cag.isPresent()) {
                Category cag = _cag.get();
                cag.setName(category.getName());
                return new ResponseEntity<>(categoryRepository.save(cag), HttpStatus.OK);
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
            categoryRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
