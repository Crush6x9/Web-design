package com.neu.mapper;

import com.neu.domain.EntityTag;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EntityTagMapper {
    List<EntityTag> findByEntityId(Long entityId);
    int insert(EntityTag entityTag);
}