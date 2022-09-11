package com.dsm.enums;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 20220825
 **/
public enum Charactor {
    NOMAL("平民"),
    SPY("平民"); //定义实例，调用的时候实例都可以被使用
    Charactor(String name){
        this.name = name;
    }
    public String name;
    public String getName(){
        return this.name;
    }
}


