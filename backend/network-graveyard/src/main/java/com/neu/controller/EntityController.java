package com.neu.controller;

import com.neu.domain.Entity;
import com.neu.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/entities")
public class EntityController {
    @Autowired
    private EntityService entityService;

    @GetMapping
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", entityService.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", entityService.findById(id));
        return result;
    }

    @PostMapping
    public Map<String, Object> add(@Valid @RequestBody Entity entity) {
        Map<String, Object> result = new HashMap<>();
        entity.setCreateTime(new java.util.Date());
        entity.setUpdateTime(new java.util.Date());
        entityService.save(entity);
        result.put("code", 200);
        result.put("msg", "添加成功");
        return result;
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(@PathVariable Long id, @Valid @RequestBody Entity entity) {
        Map<String, Object> result = new HashMap<>();
        entity.setId(id);
        entity.setUpdateTime(new java.util.Date());
        entityService.save(entity);
        result.put("code", 200);
        result.put("msg", "更新成功");
        return result;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        entityService.delete(id);
        result.put("code", 200);
        result.put("msg", "删除成功");
        return result;
    }

    @GetMapping("/search")
    public Map<String, Object> search(@RequestParam String keyword) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", entityService.search(keyword));
        return result;
    }
}