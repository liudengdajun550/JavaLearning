package com.dsm.vue2websocket.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dsm.vue2websocket.WebSocket;
import com.dsm.vue2websocket.bean.User;


/**
 * 统一管理session、websocket、curUser
 */
public class CurPool {

    public static Map<Integer, WebSocket> webSockets = new ConcurrentHashMap<>(); //这个应该是自定的websocket
    // list 里面第一个存sessionId，第二个存session
    public static Map<Integer, List<Object>> sessionPool = new ConcurrentHashMap<>();
    // 当前登录用户x
    public static Map<String, User> curUserPool = new ConcurrentHashMap<>();
}
