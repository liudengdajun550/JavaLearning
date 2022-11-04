package com.dsm.clickhouse;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date
 **/
public class StartOf {
    //时分统计：https://www.jianshu.com/p/7a62f578c608
    //利用clickhouse中的toStartOf*()函数，将时间归属到相同点，然后利用分组统计即可。
    /**
     * toStartOf*()函数：
     *
     * toStartOfInterval()
     * toStartOfHour()
     * toStartOfFifteenMinutes()
     * toStartOfFiveMinute()
     * toStartOfDay()
     * toStartOfMonth()
     * toStartOfQuarter()
     * toStartOfWeek()
     *
     * 作者：EdgeE
     * 链接：https://www.jianshu.com/p/7a62f578c608
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 主要讲一下toStartOfInterval(datetime, interval)函数,可以利用后面interval参数，任意指定时间间隔，如需要完成间隔2分钟的分时统计：
     *
     * select
     * toStartOfInterval(trade_time, INTERVAL 2  minute) as minute,
     * count() as volume
     * from table_all
     * group by minute
     * order by volume desc;
     * */
    //时间戳转为时间戳https://cloud.tencent.com/developer/article/1987036
}
