package com.example.pharmacy.service.item;

import com.example.pharmacy.model.item.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagService {
    public ResponseEntity<Tag> createTag(Tag tag);

    public ResponseEntity<List<Tag>> listAllTags(String uuid);

    public ResponseEntity<Tag> getOneTags(String uuid);

    public ResponseEntity<Tag> updateTag(Tag tag, String uuid);

    public ResponseEntity<Tag> deleteTag(String uuid);
}
