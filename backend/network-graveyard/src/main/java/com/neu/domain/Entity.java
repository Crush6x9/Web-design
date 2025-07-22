package com.neu.domain;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Entity {
    private Long id;
    @NotBlank(message = "产品名称不能为空")
    private String name;
    private String description;
    private Long categoryId;
    private Date launchDate;
    private Date discontinuationDate;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}