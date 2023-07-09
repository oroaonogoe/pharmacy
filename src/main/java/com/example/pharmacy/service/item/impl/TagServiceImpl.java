package com.example.pharmacy.service.item.impl;

import com.example.pharmacy.model.item.Tag;
import com.example.pharmacy.repository.item.TagRepository;
import com.example.pharmacy.service.item.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public ResponseEntity<Tag> create(Tag tag) {
        try {
            return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
