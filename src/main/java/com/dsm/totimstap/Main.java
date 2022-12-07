package com.dsm.totimstap;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date
 **/
public class Main {
    public static void main(String[] args) {
        TimeStapTransfer timeStapTransfer = new TimeStapTransfer();
        int seconds = 17854, msec = 10945;// 秒，毫秒
//        System.out.println(timeStapTransfer.secToTime(seconds));
        System.out.println(msec + "毫秒转换格式时间：\t" + timeStapTransfer.msecToTime(msec));
//        System.out.println("当前时间（时:分：秒.毫秒）\t" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
    }
}
