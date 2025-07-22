package com.neu.mapper;

import com.neu.domain.Media;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MediaMapper {
    List<Media> findByEntityId(Long entityId);
    int insert(Media media);
}