package com.neu.controller;

import com.neu.domain.SysUser;
import com.neu.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public Map<String, Object> login(@Valid @RequestBody SysUser user) {
        Map<String, Object> result = new HashMap<>();
        if (sysUserService.validateUser(user.getUserName(), user.getPassword())) {
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set("token:" + token, user.getUserName(), 1, TimeUnit.HOURS);
            result.put("code", 200);
            result.put("token", token);
            result.put("msg", "登录成功");
        } else {
            result.put("code", 401);
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }
}