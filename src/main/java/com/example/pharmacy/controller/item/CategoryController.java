package com.example.pharmacy.controller.item;

import com.example.pharmacy.model.item.Category;
import com.example.pharmacy.model.user.Profile;
import com.example.pharmacy.service.item.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/api/item/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Category>> listAll(String id) {
        return categoryService.listAll(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> list(@PathVariable String id) {
        return categoryService.list(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        return categoryService.delete(id);
    }
}
