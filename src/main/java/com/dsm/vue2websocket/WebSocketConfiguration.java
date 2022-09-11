package com.dsm.vue2websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.09.11
 **/
/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.09.10
 * https://blog.csdn.net/qq_43436117/article/details/125096526
 **/
@Configuration //@Configuration注解表明这个类是一个配置类。可以启动组件扫描，用来将带有@Bean的实体进行实例化bean等
//https://blog.csdn.net/Hong_pro/article/details/104409720
@EnableWebSocket //@EnableWebSocket 注解 设置socket服务注册
//https://blog.csdn.net/chenyang1010/article/details/100188084
public class WebSocketConfiguration { //websocket的配置类
    //发送消息的大小限制
    private static final int MAX_MESSAGE_SIZE = 100 * 100 * 1024;
    //session空闲会话超时设置
    private static final long MAX_IDLE = 60 * 60 * 1000;
    /**
     * ServerEndPointExporter，在springboot内置容器（嵌入式容器）中运行时，必须上下文提供ServerEndpointExporter
     * 但是在tomcat容器中运行时，扫描工作会交给容器处理，不需要bean注入,因此下面这段代码旨在开发库中存在，并没有合并提交的过程库
     */
    @Bean //@Bean可理解为用spring的时候xml里面的<bean>标签
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public ServletServerContainerFactoryBean createServletServerContainerFactoryBean() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(MAX_MESSAGE_SIZE);
        container.setMaxBinaryMessageBufferSize(MAX_MESSAGE_SIZE);
        container.setMaxSessionIdleTimeout(MAX_IDLE);
        return container;
    }

}

