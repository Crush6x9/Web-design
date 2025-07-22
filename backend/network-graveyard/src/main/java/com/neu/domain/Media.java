package com.neu.domain;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Media {
    private Long id;
    @NotNull(message = "产品ID不能为空")
    private Long entityId;
    @NotBlank(message = "文件名不能为空")
    private String name;
    @NotBlank(message = "文件URL不能为空")
    private String url;
    @NotNull(message = "文件类型不能为空")
    private Integer type;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}