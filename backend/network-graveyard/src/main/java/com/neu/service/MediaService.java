package com.neu.service;

import com.neu.domain.Media;
import com.neu.mapper.MediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MediaService {
    @Autowired
    private MediaMapper mediaMapper;

    public List<Media> findByEntityId(Long entityId) {
        return mediaMapper.findByEntityId(entityId);
    }

    public Media save(Media media) {
        mediaMapper.insert(media);
        return media;
    }
}