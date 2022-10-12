package com.dsm.clickhouse;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.10.09
 **/
public class Main {
    //官网：https://clickhouse.com/docs/zh/
    //https://clickhouse.com/docs/en/operations/system-tables/columns
    //https://blog.csdn.net/haveanybody/article/details/122775356?spm=1001.2014.3001.5502
    /**
     * 如果projection的定义语句是ORDER BY，则projection的子目录存储引擎就是MergeTree，
     * 如果projection的定义语句是GROUP BY，底层存储引擎变成AggregatingMergeTree，所有聚合函数都转换为AggregateFunction。
     * 当在查询中，能匹配到的projection时，就会使用部分预处理好的数据直接返回，这也正是projection加速的本质。
     * 例如可以定义一个包含GROUP BY的聚合projection，对于明细数据可以直接查原表，聚合数据通过projection获得。
     *
     * 目前projection不支持跨表操作，所以对于有跨表的预聚合的场景，例如join，还是要利用物化视图。
     * ————————————————
     * 版权声明：本文为CSDN博主「大白兔黑又黑」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/haveanybody/article/details/126285494
     * */
    /**
     * CREATE TABLE [IF NOT EXISTS] [db_name.]table_name(
     name1 [type] [DEFAULT|MATERIALIZED|ALIAS expr],
     name2 [type] [DEFAULT|MATERIALIZED|ALIAS expr],
     ...
     ) ENGINE = MergeTree()
     [PARTITION BY expr]
     [ORDER BY expr]
     [PRIMARY KEY expr]
     [SAMPLE BY expr]
     [SETTINGS name=value, ...]
         * ENGINE = MergeTree()
         * ENGINE=ReplacingMergeTree表引擎：具有删除重复数据的特性，
         * ENGINE=SummingMergeTree表引擎：会按照排序键自动聚合数据。
         * https://blog.csdn.net/qq_21383435/article/details/122812921?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7EPayColumn-1-122812921-blog-115250114.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7EPayColumn-1-122812921-blog-115250114.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=1
         * ENGINE=ReplicatedMergeTree('/clickhouse/tables/01/tb_order', 'tb_order_01') :为tb_order表创建一个副本表tb_order_01，提高系统可用性
         *  https://www.pudn.com/news/625685286a05c103570c7c2c.html
     *
     * PARTITION BY toDate(operator_time / 1000)
     * PARTITION BY：分区是表的分区，具体的DDL操作关键词是 PARTITION BY，指的是一个表按照某一列数据（比如日期）进行分区，对应到最终的结果就是不同分区的数据会写入不同的文件中。
     * 分片复用了数据库的分区，相当于在原有的分区下，作为第二层分区， 是在不同节点/机器上的体现。
     * http://events.jianshu.io/p/178a01e0ae6e
     *
     * */
}
