package com.neu.domain;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class SysUser {
    private Long userId;
    private Long deptId;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    private String nickName;
    private String userType;
    private String email;
    private String phonenumber;
    private String sex;
    private String avatar;
    @NotBlank(message = "密码不能为空")
    private String password;
    private String status;
    private String delFlag;
    private String loginIp;
    private Date loginDate;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;
}