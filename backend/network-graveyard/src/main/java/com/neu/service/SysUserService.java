package com.neu.service;

import com.neu.domain.SysUser;
import com.neu.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
    }

    public boolean validateUser(String userName, String password) {
        SysUser user = findByUserName(userName);
        if (user == null || !user.getStatus().equals("0") || !user.getDelFlag().equals("0")) {
            return false;
        }
        return new BCryptPasswordEncoder().matches(password, user.getPassword());
    }
}