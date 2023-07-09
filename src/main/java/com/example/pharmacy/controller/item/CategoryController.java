package com.example.pharmacy.controller.item;


import com.example.pharmacy.model.item.Category;
import com.example.pharmacy.service.item.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/item-category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Category>> getAllCategories(String uuid) {
        return categoryService.getAllCategories(uuid);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<Category> getOneCategory(@PathVariable String uuid) {
        return categoryService.getOneCategory(uuid);
    }

    @PutMapping(value = "/update/{uuid}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable String uuid){
        return categoryService.updateCategory(category, uuid);
    }

    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<Category> deleteCategory(@PathVariable String uuid){
        return categoryService.deleteCategory(uuid);
    }

}
