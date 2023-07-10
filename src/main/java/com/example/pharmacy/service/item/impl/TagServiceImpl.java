package com.example.pharmacy.service.item.impl;

import com.example.pharmacy.model.item.Tag;
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
    public ResponseEntity<Tag> create(Tag tag) {
        try {
            return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Tag>> listAll(String id) {
        try {
            List<Tag> _tag = new ArrayList<>();
            if (id == null)
                _tag.addAll(tagRepository.findAll());
            else
                tagRepository.findById(id);
            if (_tag.isEmpty())
                return new ResponseEntity<>(_tag, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(_tag, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Tag> list(String id) {
        try {
            Optional<Tag> _tag = tagRepository.findById(id);
            return _tag.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Tag> update(String id, Tag tag) {
        try {
            Optional<Tag> _tag = tagRepository.findById(id);
            if(_tag.isPresent()) {
                Tag updateTag = _tag.get();
                updateTag.setName(tag.getName());
                return new ResponseEntity<>(tagRepository.save(updateTag), HttpStatus.ACCEPTED);
            } else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> delete(String id) {
        try {
            tagRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
