package com.neu.mapper;

import com.neu.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SysUserMapper {
    List<SysUser> findAll();
    SysUser findByUserName(String userName);
}