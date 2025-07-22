package com.neu.controller;

import com.neu.domain.Media;
import com.neu.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    private MediaService mediaService;
    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/{entityId}")
    public Map<String, Object> list(@PathVariable Long entityId) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", mediaService.findByEntityId(entityId));
        return result;
    }

    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file, @RequestParam Long entityId) {
        Map<String, Object> result = new HashMap<>();
        if (file.isEmpty()) {
            result.put("code", 400);
            result.put("msg", "文件为空");
            return result;
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        File dest = new File(uploadDir + "/" + fileName);
        try {
            dest.getParentFile().mkdirs();
            file.transferTo(dest);
            Media media = new Media();
            media.setEntityId(entityId);
            media.setName(fileName);
            media.setUrl("/uploads/" + fileName);
            media.setType(file.getContentType().startsWith("image") ? 1 : 2);
            media.setCreateTime(new java.util.Date());
            media.setUpdateTime(new java.util.Date());
            mediaService.save(media);
            result.put("code", 200);
            result.put("msg", "上传成功");
            result.put("data", media);
        } catch (IOException e) {
            result.put("code", 500);
            result.put("msg", "上传失败：" + e.getMessage());
        }
        return result;
    }
}