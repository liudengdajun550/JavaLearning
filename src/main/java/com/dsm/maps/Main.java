package com.dsm.maps;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.10.08
 **/
public class Main {
    public static void main(String[] args) {
        //Maps.newHashMapWithExpectedSize(),用于初始化map,https://blog.csdn.net/weixin_43584835/article/details/118024342
        Map<String, Object> diffQuota = Maps.newHashMapWithExpectedSize(3);
    }
}
