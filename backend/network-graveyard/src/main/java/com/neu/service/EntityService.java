package com.neu.service;

import com.neu.domain.Entity;
import com.neu.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntityService {
    @Autowired
    private EntityMapper entityMapper;

    public List<Entity> findAll() {
        return entityMapper.findAll();
    }

    public Entity findById(Long id) {
        return entityMapper.findById(id);
    }

    public Entity save(Entity entity) {
        if (entity.getId() == null) {
            entityMapper.insert(entity);
        } else {
            entityMapper.update(entity);
        }
        return entity;
    }

    public void delete(Long id) {
        entityMapper.delete(id);
    }

    public List<Entity> search(String keyword) {
        return entityMapper.searchByNameOrTag(keyword);
    }
}