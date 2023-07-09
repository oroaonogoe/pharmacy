package com.example.pharmacy.controller.item;

import com.example.pharmacy.model.item.Tag;
import com.example.pharmacy.service.item.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
