package com.example.pharmacy.controller.item;

import com.example.pharmacy.model.item.Tag;
import com.example.pharmacy.service.item.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/item/tag")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/create")
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        return tagService.create(tag);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Tag>> listAll(String id) {
        return tagService.listAll(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> list(@PathVariable String id) {
        return tagService.list(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tag> update(@PathVariable String id, @RequestBody Tag tag) {
        return tagService.update(id, tag);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        return tagService.delete(id);
    }
}
