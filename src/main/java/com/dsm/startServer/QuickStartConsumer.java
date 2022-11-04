package com.dsm.startServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date
 **/
//springBoot使用包扫描设置启动类
@ComponentScan(basePackages = "com.dsm.startServer")
public class QuickStartConsumer {
        public static void main(String[] args) {
            new AnnotationConfigApplicationContext(QuickStartConsumer.class);
        }
}
