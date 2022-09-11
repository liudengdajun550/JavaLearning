package com.dsm.vue2websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.dsm.vue2websocket.bean.User;
import com.dsm.vue2websocket.utils.CurPool;


/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.09.10
 **/
@Component
@ServerEndpoint("/websocket/{userId}/{sessionId}")//注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端。注解的值将被用于监听用户连接的终端访问URL地址。
//https://www.sohu.com/a/254735546_355142
public class WebSocket {
    private Session session;
    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value="userId") Integer userId, @PathParam(value="sessionId") String sessionId) {
        this.session = session;
        CurPool.webSockets.put(userId, this);
        List<Object> list = new ArrayList<>();
        list.add(sessionId);
        list.add(session);
        CurPool.sessionPool.put(userId , list);
        System.out.println("【websocket消息】有新的连接，总数为:"+CurPool.webSockets.size());
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        // 断开连接删除用户删除session
        Integer userId = Integer.parseInt(this.session.getRequestParameterMap().get("userId").get(0));
        CurPool.sessionPool.remove(userId); //session池中删除
        CurPool.webSockets.remove(userId); //socket池子中删除
        User user = new User();//应该从数据库中根据userId获取数据现在先mock
        user.setId(userId);
        user.setName(userId+"");
        CurPool.curUserPool.remove(user.getName()); //当前用户池子中删除
        System.out.println("【websocket消息】连接断开，总数为:"+CurPool.webSockets.size());
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * https://blog.csdn.net/D15306354614/article/details/121050989
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("来自客户端的消息:" + message);

    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        error.printStackTrace();

    }

}
