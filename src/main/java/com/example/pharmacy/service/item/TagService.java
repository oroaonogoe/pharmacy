package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TagService {
    public ResponseEntity<Tag> create(Tag tag);
    public ResponseEntity<List<Tag>> listAll(String id);
    public ResponseEntity<Tag> list(String id);
    public ResponseEntity<Tag> update(String id, Tag tag);
    public ResponseEntity<HttpStatus> delete(String id);
}
