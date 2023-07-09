package com.example.pharmacy.controller.item;

import com.example.pharmacy.model.item.Tag;
import com.example.pharmacy.service.item.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/tag")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/create")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Tag>> listAllTags(String uuid) {
        return tagService.listAllTags(uuid);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Tag> getOneTag(@PathVariable String uuid) {
        return tagService.getOneTags(uuid);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag, @PathVariable String uuid) {
        return tagService.updateTag(tag, uuid);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Tag> deleteTag(@PathVariable String uuid) {
        return tagService.deleteTag(uuid);
    }
}
