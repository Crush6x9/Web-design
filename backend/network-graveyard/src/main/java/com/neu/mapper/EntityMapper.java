package com.neu.mapper;

import com.neu.domain.Entity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EntityMapper {
    List<Entity> findAll();
    Entity findById(Long id);
    int insert(Entity entity);
    int update(Entity entity);
    int delete(Long id);
    List<Entity> searchByNameOrTag(String keyword);
}