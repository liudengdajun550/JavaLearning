package com.dsm.million2;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date
 **/
public class HHmmSS {
    public static void main(String[] args) {
        /**
         * 设t=3600000毫秒，已知1秒=1000毫秒，那么转时分秒格式时，时、分、秒对应的数字分别是多少？
         * 解：
         * 求秒：因为1分钟=60秒，且1秒=1000毫秒
         *      所以(t % (60*1000) ) / 1000的结果就是对应的秒
         * 求分：因为1分钟=60秒，1小时=60分钟，且1秒=1000毫秒
         *      所以(t % (60*60*1000)) / (60*1000)的结果就是对应的分
         * 求时：同理(t / (60*60*1000))的结果就是对应的时
         *
         * t毫秒对应的时分秒是：
         * int hours = t / 3600000;
         * int minutes = (t % 3600000) / 60000;
         * int seconds = (t % 60000 ) / 1000;
         * */
        long million = 10000;
        System.out.println("转化后的时间="+million / 3600000+":"+(million % 3600000) / 60000+":"+(million % 60000 ) / 1000);
    }
}
