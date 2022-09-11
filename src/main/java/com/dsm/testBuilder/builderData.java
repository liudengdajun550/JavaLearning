package com.dsm.testBuilder;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date
 **/
@Data //这个注释只能生成set和get方法
@Builder //这个注释可以生成builder方式
public class builderData {
    @NotNull(message = "角色号码")
    private Integer identidyNum;

    @NotNull(message = "角色")
    private String charactor;

    @NotNull(message = "角色名词")
    private String passWord;

    private boolean occupied;
}
