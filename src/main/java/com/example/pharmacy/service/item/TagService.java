package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Tag;
import org.springframework.http.ResponseEntity;

public interface TagService {
    public ResponseEntity<Tag> create(Tag tag);
}
