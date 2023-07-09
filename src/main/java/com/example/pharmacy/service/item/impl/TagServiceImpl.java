package com.example.pharmacy.service.item.impl;

import com.example.pharmacy.model.item.Item;
import com.example.pharmacy.model.item.Tag;
import com.example.pharmacy.repository.item.ItemRepository;
import com.example.pharmacy.repository.item.TagRepository;
import com.example.pharmacy.service.item.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public ResponseEntity<Tag> createTag(Tag tag) {
        try {
            return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Tag>> listAllTags(String uuid) {
        try {
            List<Tag> tags = new ArrayList<>();
            if (uuid == null)
                tags.addAll(tagRepository.findAll());
            else
                tagRepository.findById(uuid);
            if (tags.isEmpty())
                return new ResponseEntity<>(tags, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(tags, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Tag> getOneTags(String uuid) {
        try {
            Optional<Tag> tagUuid = tagRepository.findById(uuid);
            return tagUuid.map(tagV -> new ResponseEntity<>(tagV, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Tag> updateTag(Tag tag, String uuid) {
        try {
            Optional<Tag> tagUuid = tagRepository.findById(uuid);
            if (tagUuid.isPresent()){
                 Tag _tag = tagUuid.get();
                 _tag.setName(tag.getName());
                 return new ResponseEntity<>(tagRepository.save(_tag), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Tag> deleteTag(String uuid) {
        try {
            tagRepository.deleteById(uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
