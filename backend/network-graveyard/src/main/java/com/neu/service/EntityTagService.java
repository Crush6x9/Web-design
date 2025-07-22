package com.neu.service;

import com.neu.domain.EntityTag;
import com.neu.mapper.EntityTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntityTagService {
    @Autowired
    private EntityTagMapper entityTagMapper;

    public List<EntityTag> findByEntityId(Long entityId) {
        return entityTagMapper.findByEntityId(entityId);
    }

    public EntityTag save(EntityTag entityTag) {
        entityTagMapper.insert(entityTag);
        return entityTag;
    }
}