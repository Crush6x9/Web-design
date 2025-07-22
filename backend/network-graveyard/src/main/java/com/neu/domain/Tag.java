package com.neu.domain;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Tag {
    private Long id;
    @NotBlank(message = "标签名称不能为空")
    private String name;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}