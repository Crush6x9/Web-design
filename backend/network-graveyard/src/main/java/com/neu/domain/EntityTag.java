package com.neu.domain;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class EntityTag {
    @NotNull(message = "产品ID不能为空")
    private Long entityId;
    @NotNull(message = "标签ID不能为空")
    private Long tagId;
}