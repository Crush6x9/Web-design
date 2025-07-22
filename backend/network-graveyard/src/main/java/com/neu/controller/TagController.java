package com.neu.controller;

import com.neu.domain.Tag;
import com.neu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", tagService.findAll());
        return result;
    }

    @PostMapping
    public Map<String, Object> add(@Valid @RequestBody Tag tag) {
        Map<String, Object> result = new HashMap<>();
        tag.setCreateTime(new java.util.Date());
        tag.setUpdateTime(new java.util.Date());
        tagService.save(tag);
        result.put("code", 200);
        result.put("msg", "添加成功");
        return result;
    }
}