package com.neu.controller;

import com.neu.domain.EntityTag;
import com.neu.service.EntityTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/entity-tags")
public class EntityTagController {
    @Autowired
    private EntityTagService entityTagService;

    @GetMapping("/{entityId}")
    public Map<String, Object> list(@PathVariable Long entityId) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", entityTagService.findByEntityId(entityId));
        return result;
    }

    @PostMapping
    public Map<String, Object> add(@Valid @RequestBody EntityTag entityTag) {
        Map<String, Object> result = new HashMap<>();
        entityTagService.save(entityTag);
        result.put("code", 200);
        result.put("msg", "添加成功");
        return result;
    }
}