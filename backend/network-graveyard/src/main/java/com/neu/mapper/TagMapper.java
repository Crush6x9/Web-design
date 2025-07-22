package com.neu.mapper;

import com.neu.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TagMapper {
    List<Tag> findAll();
    int insert(Tag tag);
}