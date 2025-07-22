package com.neu.service;

import com.neu.domain.Tag;
import com.neu.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;

    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    public Tag save(Tag tag) {
        tagMapper.insert(tag);
        return tag;
    }
}